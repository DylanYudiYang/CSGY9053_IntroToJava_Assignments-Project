package chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

public class ChatClient extends JFrame implements Runnable {

    private static int WIDTH = 400;
    private static int HEIGHT = 300;
    private static String HOST = "localhost";
    private static int PORT = 9898;

    private JTextArea chatTextArea;
    private JTextField inputField;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ChatClient() {
        super("Chat Client");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createChatArea();
        createInputField();
        this.setVisible(true);
    }

    private void createChatArea() {
        chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatTextArea);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private void createInputField() {
        inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                out.println(message);
                inputField.setText("");
            }
        });
        this.add(inputField, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        new Thread(chatClient).start();
    }

    @Override
    public void run() {
        try {
            socket = new Socket(HOST, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                chatTextArea.append(message + "\n");
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
}
