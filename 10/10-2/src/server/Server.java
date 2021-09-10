package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    OutputStream out;
    InputStream in;
    String message;
    String newMessage;

    public Server(int port) {

        ExecutorService pool = Executors.newCachedThreadPool();
        int count = 0;

        try (ServerSocket welcome = new ServerSocket(port)) {
            System.out.println("Server started.");
            System.out.println("Waiting for a client ...");

            while (count < 10) {
                Socket connection = welcome.accept();
                count++;
                System.out.println("client" + count + " accepted!");
                pool.execute(new ClientHandler(connection, count));
            }

            pool.shutdown();
            System.out.print("Closing server... ");

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}