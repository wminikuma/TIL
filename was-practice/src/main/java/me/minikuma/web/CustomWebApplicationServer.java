package me.minikuma.web;

import me.minikuma.caculator.Calculator;
import me.minikuma.web.parsing.HttpRequest;
import me.minikuma.web.parsing.HttpResponse;
import me.minikuma.web.parsing.QueryStrings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class CustomWebApplicationServer {
    private final int port;
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket socket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket = null;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = socket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected.");

                /**
                 * 요청이 들어 오면 메인 Thread 에서 처리 해야함
                 */
                try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
                    // input stream > buffer reader
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    /*String line = null;

                    while(!Objects.equals(line = br.readLine(), "")) {
                        System.out.println(line);
                    }*/

                    // http request
                    HttpRequest httpRequest = new HttpRequest(br);

                    if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                        logger.info("Request >>>>>>>>");
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
                }
            }
        }
    }
}