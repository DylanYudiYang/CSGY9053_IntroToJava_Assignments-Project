package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatHandler implements Runnable {
    private Socket socket;
    private ChatServer server;
    private PrintWriter out;
    private int clientNumber;

    public ChatHandler(Socket socket, ChatServer server, int clientNumber) {
        this.socket = socket;
        this.server = server;
        this.clientNumber = clientNumber;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                server.broadcastMessage("Client " + clientNumber + ": " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
