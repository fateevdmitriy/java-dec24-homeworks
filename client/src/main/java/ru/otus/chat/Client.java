package ru.otus.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket socket = new Socket("localhost", 8189);
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    DataInputStream in = new DataInputStream(socket.getInputStream());
    
    public Client() throws IOException {
        try {
            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        if (message.startsWith("/")) {
                            if (message.equals("/exitok")) {
                                break;
                            }
                            if (message.equals("/exitreq")) {
                                out.writeUTF("/exit");
                                break;
                            }
                        } else {
                            System.out.println(message);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    disconnect();
                }
            }).start();
            
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                out.writeUTF(message);
                if (message.equals("/exit")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Соединение закрыто сервером.");
            e.printStackTrace();
        }
    }

    public void disconnect() {
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
