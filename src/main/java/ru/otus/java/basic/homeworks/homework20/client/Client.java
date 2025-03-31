package ru.otus.java.basic.homeworks.homework20.client;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.InputMismatchException;
import java.util.Scanner;
import ru.otus.java.basic.homeworks.homework20.util.SimpleClient;

public class Client {
    private static final int serverPort = 8080;
    
    public static void main(String[] args) {
        while (true) {
            try (Socket socket = new Socket("localhost", serverPort)) {
                SimpleClient client = new SimpleClient(socket.getInputStream(), socket.getOutputStream());
                String mathOpsStr = client.receiveString();
                System.out.println("Доступные мат.операции: " + mathOpsStr);

                Double firstNum = inputDoubleNum("первое число");
                Double secondNum = inputDoubleNum("второе число");
                char opsSign = inputOperationSign(mathOpsStr);
                client.sendTwoNumbersAndOperation(firstNum, secondNum, opsSign);
                Double calcResult = client.receiveDouble();
                System.out.println("Результат вычислений, полученный от сервера: " + calcResult);
                
                System.out.println("\nЕсли хотите завершить выполнение клиентского приложения, введите 'exit'.");
                Scanner scanner = new Scanner(System.in);
                String userChoice = scanner.nextLine();
                client.sendString(userChoice);
                if (userChoice.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    System.out.println("Продолжаем, повторим вычисления снова.");
                }
            } catch (SocketException e) {
                System.out.println("Сервер закрыл соединение.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }    
    
    private static Double inputDoubleNum(String numberName) {
        Double num = null;
        while (true) {
            System.out.printf("Введите %s:\n", numberName);
            Scanner scanner = new Scanner(System.in);    
            try {
                num = scanner.nextDouble();
                break;
            } catch (InputMismatchException ime) {
                System.out.println("Введеное значение не является числом.");
            }
        }
        return num;
    }
    
    private static char inputOperationSign(String operationsStr) {
        char opsSign;
        while (true) {
            System.out.println("Укажите одну из следующих  мат. операций: " + operationsStr);
            Scanner scanner = new Scanner(System.in);
            opsSign = scanner.next().charAt(0);
            if (operationsStr.indexOf(opsSign) != -1) {
                break;
            }
        }
        return opsSign;
    }
    
}
