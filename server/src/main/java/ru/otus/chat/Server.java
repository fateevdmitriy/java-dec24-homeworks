package ru.otus.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private final int port;
    private List<ClientHandler> clients;
    private AuthenticationProvider authenticationProvider;

    public Server(int port) {
        this.port = port;
        clients = new CopyOnWriteArrayList<>();
        authenticationProvider = new InMemoryAuthenticationProvider(this);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту " + port);
            
            authenticationProvider.initialize();
            while (true) {
                Socket socket = serverSocket.accept();
                subscribe( new ClientHandler(socket, this) );
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AuthenticationProvider getAuthenticationProvider() {
        return authenticationProvider;
    }

    public ClientHandler getClientHandlerByUsername(String username) {
        for (ClientHandler client : clients) {
            if (client.getUsername() != null && client.getUsername().equalsIgnoreCase(username)) {
                return client;
            }
        }
        return null;         
    }

    public boolean isUsernameBusy(String username) {
        for (ClientHandler client : clients) {
            if (client.getUsername() != null && client.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        System.out.println("Клиент " + clientHandler.getUsername() + " отключился.");
    }

    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMsg(message);
        }
    }
    
}
