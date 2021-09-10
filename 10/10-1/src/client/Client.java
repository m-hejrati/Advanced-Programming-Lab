package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    OutputStream out;
    InputStream in;
    String msg;

    public Client(int port) {

        try (Socket client = new Socket("127.0.0.1", port)) {
            System.out.println("Connected to server. \n");

            message(client);

        } catch (IOException e) {
            System.err.println(e);
        }

    }

    public void message(Socket client) throws IOException {

        out = client.getOutputStream();
        in = client.getInputStream();

        byte[] buffer = new byte[2048];

        Scanner input = new Scanner(System.in);

        do {
            msg = input.nextLine();

            out.write(msg.getBytes());
            int read = in.read(buffer);
            System.out.println("+From Server: " + new String(buffer, 0, read));

        } while (!msg.equals("over"));

    }
}