package ru.otus.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientHandler {
    private final Socket socket;
    private final Server server;
    private final DataInputStream in;
    private final DataOutputStream out;

    private final String username;
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
        username = "user" + userCount;

        new Thread(() -> {
            try {
                System.out.printf("Клиент '%s' подключился.%n", username);
                sendMsg("Доступные команды: Отправка сообщения клиенту по имени: '/w ИмяКлиента Сообщение'. " +
                        "Завершение работы клиента: '/exit'. Произвольное сообщение отправится всем клиентам. Имя клиента: " + username);

                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        String[] elements = message.split(" ");
                        if (elements[0].equals("/w")) {
                            if (elements.length > 2) {
                                if (username.equalsIgnoreCase(elements[1])) {
                                    sendMsg("Попытка отправить сообщение самому себе. Проверьте, что имя адресата указано корректно.");
                                    continue;
                                }
                                ClientHandler targetClient = server.getClientHandlerByClientName(elements[1]);
                                if (targetClient != null) {
                                    String targetMessage = 
                                            message.substring(message.indexOf(elements[1]) + elements[1].length()).trim();
                                    targetClient.sendMsg("Сообщение от " + username + ": " + targetMessage);
                                    sendMsg("Сообщение успешно отправлено клиенту " + elements[1] + ".");
                                    System.out.printf("Клиент %s передал сообщение клиенту %s.%n", username, elements[1]);
                                } else {
                                    sendMsg("Не найден клиент с именем '" + elements[1] + "', невозможно отправить сообщение.");
                                }
                            } else {
                                sendMsg("Некорретный формат команды. Укажите команду в формате: '/w ИмяКлиента Сообщение'.");
                            }
                        } else if (elements[0].equals("/exit")) {
                            sendMsg("/exitok");
                            break;
                        } else {
                            sendMsg("Неизвестная команда. Введите одну из доступных команд сервера в формате '/команда опции'.");
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

