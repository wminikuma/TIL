package me.minikuma.web;

import me.minikuma.caculator.Calculator;
import me.minikuma.web.parsing.HttpRequest;
import me.minikuma.web.parsing.HttpResponse;
import me.minikuma.web.parsing.QueryStrings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RequestHandler implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    private final Socket clientSocket;

    public RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        /**
         * (Step 2) 사용자 요청이 들어올때 마다 Thread 를 새로 생성한다.
         */
        logger.info("[Request Handler] new client {} started.", Thread.currentThread().getName());

        try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
            // input stream > buffer reader
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            DataOutputStream dos = new DataOutputStream(out);

            HttpRequest httpRequest = new HttpRequest(br);

            if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryString();

                int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));
                String operator = queryStrings.getValue("operator");

                int result = Calculator.calculator(operand1, operator, operand2);
                byte[] body = String.valueOf(result).getBytes();
                // header 생성
                HttpResponse httpResponse = new HttpResponse(dos);
                httpResponse.responseHeader("application/json", body.length);
                httpResponse.responseBody(body);
            }
        } catch (IOException e) {
            logger.error("Thread 생성 에러!");
        }
    }
}
