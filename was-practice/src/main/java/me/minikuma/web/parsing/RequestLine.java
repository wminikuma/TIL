package me.minikuma.web.parsing;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String uri;
    private QueryStrings queryStrings;

    public RequestLine(String method, String uri, String queryString) {
        this.method = method;
        this.uri = uri;
        this.queryStrings = new QueryStrings(queryString);
    }

    // GET /calculate?operand1=11&operator=*&operand2=22 HTTP/1.1
    public RequestLine(String request) {
        String[] token = request.split(" "); // GET /calculate?operand1=11&operator=*&operand2=22 HTTP/1.1
        this.method = token[0]; // GET

        String[] uriToken = token[1].split("\\?"); // calculate ? operand1=11&operator=*&operand2=22
        this.uri = uriToken[0]; // /calculate

        if (uriToken.length == 2) {
            this.queryStrings = new QueryStrings(uriToken[1]); // operand1=11&operator=*&operand2=22
        }
    }

    // HTTP Method 판단
    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String path) {
        return uri.equals(path);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(uri, that.uri) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, uri, queryStrings);
    }
}