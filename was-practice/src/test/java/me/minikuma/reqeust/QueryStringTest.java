package me.minikuma.reqeust;

import me.minikuma.web.parsing.QueryString;
import me.minikuma.web.parsing.QueryStrings;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueryStringTest {
    @Test
    void parsingQueryString() {
        QueryString queryString = new QueryString("operand1", "11");
        Assertions.assertThat(queryString).isNotNull();
    }

    @Test
    @DisplayName("여러 개의 Query String 을 가지는 경우")
    void parsingListQueryString() {
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=22");
        Assertions.assertThat(queryStrings.getValue("operand1")).isEqualTo("11");
        Assertions.assertThat(queryStrings.getValue("operand2")).isEqualTo("22");
        Assertions.assertThat(queryStrings.getValue("operator")).isEqualTo("*");

        Assertions.assertThat(queryStrings).isNotNull();
    }
}
