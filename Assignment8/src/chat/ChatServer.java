package chat;
import java.time.LocalDateTime;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.*;

public class ChatServer extends JFrame implements Runnable {
    private static int WIDTH = 400;
    private static int HEIGHT = 300;
    private static int PORT = 9898;

    private JTextArea debugTextArea;
    private List<ChatHandler> clients;
    private ServerSocket serverSocket;
    private int clientID = 1;

    public ChatServer() {
        super("Chat Server");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenu();
        createDebugArea();
        this.setVisible(true);

        clients = new ArrayList<>();
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener((e) -> System.exit(0));
        menu.add(exitItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }

    private void createDebugArea() {
        debugTextArea = new JTextArea();
        debugTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(debugTextArea);
        this.add(scrollPane);
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        new Thread(chatServer).start();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(PORT);
            debugTextArea.append("Server started on port " + PORT + "\n");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ChatHandler client = new ChatHandler(clientSocket, this, clientID);
                clients.add(client);
                new Thread(client).start();
                LocalDateTime currentDateTime = LocalDateTime.now();           
                debugTextArea.append("Starting thread from Client " + clientID + " at " + currentDateTime + "\n");
                debugTextArea.append("Client " + clientID + "'s address is:" + clientSocket.getRemoteSocketAddress() + "\n");
                clientID++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void broadcastMessage(String message) {
        for (ChatHandler client : clients) {
            client.sendMessage(message);
        }
    }
}
