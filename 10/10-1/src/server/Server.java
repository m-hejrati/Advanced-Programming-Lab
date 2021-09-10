package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    OutputStream out;
    InputStream in;
    String message;
    String newMessage;

    public Server(int port) {

        try (ServerSocket welcome = new ServerSocket(port)) {
            System.out.println("Server started.");
            System.out.println("Waiting for a client ...");

            try (Socket connection = welcome.accept()) {
                System.out.println("client accepted!\n");

                message(connection);

            } catch (IOException e) {
                e.printStackTrace();
                System.err.println(e);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e);
        }

    }

    public void message(Socket connection) throws IOException {

        out = connection.getOutputStream();
        in = connection.getInputStream();

        byte[] buffer = new byte[2048];

        message = "";

        do {
            int read = in.read(buffer);
            newMessage = new String(buffer, 0, read);
            System.out.println("-From Client: \t " + newMessage);

            message += "  " + newMessage;
            out.write(message.getBytes());
            System.out.println("+To Client: " + message);

        } while (!newMessage.equals("over"));

    }

}
