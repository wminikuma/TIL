package me.minikuma.reqeust;

import me.minikuma.web.parsing.RequestLine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RequestTest {
    @Test
    void requestCreate() {
        RequestLine requestLine = new RequestLine("GET /calculate?operand1=11&operator=*&operand2=22 HTTP/1.1");
        Assertions.assertThat(requestLine)
                .isNotNull()
                .isEqualTo(new RequestLine("GET", "/calculate", "operand1=11&operator=*&operand2=22"));
    }
}
