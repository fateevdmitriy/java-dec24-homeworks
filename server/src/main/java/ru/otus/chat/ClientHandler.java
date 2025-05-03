package ru.otus.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private final Socket socket;
    private final Server server;
    private final DataInputStream in;
    private final DataOutputStream out;
    
    private String username;
    private boolean authenticated;
    
    private static final String ADMIN_INFO = "Административные команды: Отключить клиента от чата: '/kick ИмяКлиента'. ";
    private static final String USER_INFO = "Пользовательские команды: Отправка сообщения клиенту по имени: '/w ИмяКлиента Сообщение'. " +
            "Завершение работы клиента: '/exit'. Произвольное сообщение отправится всем клиентам. ";
    
    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        
        new Thread(() -> {
            try {
                System.out.println("Клиент подключился.");
                
                //цикл аутентификации
                while (true) {
                    sendMsg("Перед работой с чатом необходимо выполнить аутентификацию " +
                            "/auth login password \n" +
                            "или регистрацию /reg login password username");
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equals("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                        if (message.startsWith("/auth ")) {
                            String[] elements = message.split(" ");
                            if (elements.length != 3) {
                                sendMsg("Неверный формат команды /auth. Формат команды: /auth login password");
                                continue;
                            }
                            if (server.getAuthenticationProvider().authenticate(
                                    this, elements[1], elements[2])) {
                                authenticated = true;
                                break;
                            }
                        }
                        if (message.startsWith("/reg ")) {
                            String[] elements = message.split(" ");
                            if (elements.length != 4) {
                                sendMsg("Неверный формат команды /reg. Формат команды: /reg login password username");
                                continue;
                            }
                            if (server.getAuthenticationProvider().registration(
                                    this, elements[1], elements[2], elements[3])) {
                                authenticated = true;
                                break;
                            }
                        }
                    }
                }

                UserRole userRole = server.getAuthenticationProvider().getUserRoleByUsername(username);
                String infoMsg = userRole.isAdmin() ? ADMIN_INFO + USER_INFO + "Имя админа: " + username 
                                                    : USER_INFO + "Имя пользователя: " + username;
                sendMsg(infoMsg);
                
                //цикл работы
                while (authenticated) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        String[] elements = message.split(" ");
                        if (elements[0].equals("/w")) {
                            if (elements.length > 2) {
                                if (username.equalsIgnoreCase(elements[1])) {
                                    sendMsg("Попытка отправить сообщение самому себе. Проверьте, что имя адресата указано корректно.");
                                    continue;
                                }
                                ClientHandler targetClient = server.getClientHandlerByUsername(elements[1]);
                                if (targetClient != null) {
                                    String targetMessage =
                                            message.substring(message.indexOf(elements[1]) + elements[1].length()).trim();
                                    targetClient.sendMsg("Сообщение от " + username + ": " + targetMessage);
                                    sendMsg("Сообщение успешно отправлено клиенту " + elements[1] + ".");
                                    System.out.printf("Клиент %s передал сообщение клиенту %s.%n", username, elements[1]);
                                } else {
                                    sendMsg("Не найден клиент с именем " + elements[1] + ", невозможно отправить сообщение.");
                                }
                            } else {
                                sendMsg("Некорректный формат команды. Укажите команду в формате: '/w ИмяКлиента Сообщение'.");
                            }
                        } else if (elements[0].equals("/kick")) {
                            if (userRole.isAdmin() && elements.length == 2) {
                                if (username.equalsIgnoreCase(elements[1])) {
                                    sendMsg("Администратор не может отключить от чата самого себя. Проверьте, что имя пользователя " +
                                            "в команде указано корректно.");
                                    continue;
                                }
                                ClientHandler targetClient = server.getClientHandlerByUsername(elements[1]);
                                if (targetClient != null) {
                                    targetClient.sendMsg("Администратор отключил вас от чата.");
                                    targetClient.sendMsg("/exitreq");
                                    sendMsg("Клиент " + elements[1] + " отключен по вашему запросу.");
                                    System.out.printf("Администратор отключил клиента %s от чата.%n", elements[1]);
                                } else {
                                    sendMsg("Не найден клиент с именем " + elements[1] + ", невозможно выполнить команду.");
                                }
                            } else {
                                sendMsg("Неразрешенная команда или некорректный формат команды.");
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
                System.out.println("ClientHandler exception on read for cliemt: " + username + ".");
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
