package ru.otus.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;

    private String username;
    private static int userCount = 0;

    public String getUsername() {
        return username;
    }

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        userCount++;
        username = "user_" + userCount;

        new Thread(() -> {
            try {
                System.out.printf("Клиент '%s' подключился.\n", username);
                this.sendMsg("Клиенту задано имя: "+username);
                
                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        
                        String[] elements = message.split(" ");
                        /*
                        if (elements[0].equalsIgnoreCase("/name") && elements.length > 1) {
                            System.out.printf("Клиент %s указал свое имя: %s.\n", username, elements[1]);
                            username = elements[1];                             
                        }
                        */
                        
                        if (elements[0].equals("/w") && elements.length > 2) {
                            ClientHandler targetClient = server.getClientHandlerByClientName(elements[1]);
                            if (targetClient != null) {
                                String targetClientName = targetClient.getUsername();
                                String targetMessage = 
                                        message.replaceFirst(elements[0], "").replaceFirst(elements[1], "").trim();
                                targetClient.sendMsg("Сообщение от " + username + ": " + targetMessage);
                                System.out.printf("Клиент %s отправил сообщение для клиента %s.\n", username, targetClientName);                                
                            } else {
                                //
                            }
                        } else {
                            //
                        }

                        if (message.equals("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                    } else {
                        server.broadcastMessage(username + ": " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();

    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

