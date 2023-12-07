package me.minikuma.web.parsing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {
    private List<QueryString> queryStringList = new ArrayList<>();

    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
                .forEach(s -> {
                    String[] values = s.split("=");
                    if (values.length != 2) {
                        throw new IllegalArgumentException("잘못된 Query String 입니다.");
                    }
                    queryStringList.add(new QueryString(values[0], values[1]));
                });
    }

    public String getValue(String key) {
        return this.queryStringList.stream()
                .filter(s -> s.exists(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);
    }
}
