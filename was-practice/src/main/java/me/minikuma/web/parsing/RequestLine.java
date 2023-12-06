package me.minikuma.web.parsing;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String uri;
    private String queryString;

    public RequestLine(String method, String uri, String queryString) {
        this.method = method;
        this.uri = uri;
        this.queryString = queryString;
    }

    // GET /calculate?operand1=11&operator=*&operand2=22 HTTP/1.1
    public RequestLine(String request) {
        String[] token = request.split(" "); // GET /calculate?operand1=11&operator=*&operand2=22 HTTP/1.1
        this.method = token[0]; // GET

        String[] uriToken = token[1].split("\\?"); // calculate ? operand1=11&operator=*&operand2=22
        this.uri = uriToken[0]; // /calculate

        if (uriToken.length == 2) {
            this.queryString = uriToken[1]; // operand1=11&operator=*&operand2=22
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(uri, that.uri) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, uri, queryString);
    }
}
