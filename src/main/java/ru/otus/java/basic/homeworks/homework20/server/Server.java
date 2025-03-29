package ru.otus.java.basic.homeworks.homework20.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final String CALC_OPERATIONS = "+ - * /";
    static final int serverPort = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(serverPort);
        System.out.println("Сервер запущен.");
        while (true) {
            Socket client = socket.accept();
            System.out.println("Клиент подключился к серверу по порту " + client.getPort());
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            outputStream.writeUTF(CALC_OPERATIONS);
            outputStream.flush();
            System.out.println("Сервер отправил доступные операции.");

            double num1 = inputStream.readDouble();
            System.out.println("Первое число полученное от клиента: " + num1);
            double num2 = inputStream.readDouble();
            System.out.println("Второе число полученное от клиента: " + num2);
            char sign = inputStream.readChar();
            System.out.println("Знак операции полученный от клиента: " + sign);
            
            Double resultNum = operationWithTwoNumbers(num1, num2, sign);
            outputStream.writeDouble(resultNum);
            outputStream.flush();
            System.out.println("Сервер отправил результат операции над двумя числами.");
            
            String userResponse = inputStream.readUTF();
            System.out.println("Сервер получил ответ клиента о необходимости завершении соединения: "+userResponse);
            if (userResponse.equalsIgnoreCase("exit")) {
                System.out.println("Клиент на порту " + client.getPort() + " отключился.");
                client.close();
            }
        }
    }

    private static Double operationWithTwoNumbers(Double num1, Double num2, char Operation) {
        Double result = null;
        switch (Operation) {
            case ('+'):
                result = num1 + num2;
                break;
            case ('-'):
                result = num1 - num2;
                break;
            case ('*'):
                result = num1 * num2;
                break;
            case ('/'):
                result = (num2 != 0) ? (num1 / num2) : 0;
                break;
            default:
                break;
        }
        return result;
    }
}
