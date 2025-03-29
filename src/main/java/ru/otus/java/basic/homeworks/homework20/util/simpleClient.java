package ru.otus.java.basic.homeworks.homework20.util;

import java.io.*;

public class simpleClient implements AutoCloseable {
    
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public simpleClient(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new DataInputStream(inputStream);
        this.outputStream = new DataOutputStream(outputStream);
    }

    public String receiveString() throws IOException {
        String response = null;
        try {
            response = inputStream.readUTF();
        } catch (EOFException e) {
            System.out.println("Сервер закрыл соединение.");
        }
        return response;
    }

    public Double receiveDouble() throws IOException {
        Double response = null;
        try {
            response = inputStream.readDouble();
        } catch (EOFException e) {
            System.out.println("Сервер закрыл соединение.");
        }
        return response;
    }

    public void sendString(String str) throws IOException {
        outputStream.writeUTF(str);
        outputStream.flush();
    }

    public void sendTwoNumbersAndOperation(Double num1, Double num2, char operation) throws IOException {
        outputStream.writeDouble(num1);
        outputStream.writeDouble(num2);
        outputStream.writeChar(operation);
        outputStream.flush();
        System.out.println("Отправлено на сервер: первое число: "+num1+", второе число: "+num2+", знак операции: "+operation);
    }
    
    @Override
    public void close() throws IOException {
        inputStream.close();
        outputStream.close();
    }
        
}
