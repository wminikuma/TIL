package me.minikuma.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {
    private final int port;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
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

                //TODO: 요청을 받아주는 기능을 넣어줘야 함.
                //TODO: Thread Pool
                executorService.execute(new RequestHandler(clientSocket));
            }
        }
    }
}