package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class ClientHandler implements Runnable {

    private Socket connection;
    private int clientNum;
    OutputStream out;
    InputStream in;
    String message;
    String newMessage;

    public ClientHandler(Socket connection, int clientNum) {

        this.connection = connection;
        this.clientNum = clientNum;

    }

    @Override
    public void run() {
        try {

            message(connection);
            System.out.println("Closing client" + clientNum);

        } catch (IOException e) {
            System.err.println(e);

        } finally {

            try {
                connection.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
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
            System.out.println("-From Client" + clientNum + ": \t" + newMessage);

            message += "  " + newMessage;
            out.write(message.getBytes());
            System.out.println("+To Client" + clientNum + ": " + message);

        } while (!newMessage.equals("over"));

    }

}