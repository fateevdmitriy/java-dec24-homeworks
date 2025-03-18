package ru.otus.java.basic.homeworks.homework19;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class HomeWork {

    public static void main(String[] args) {
        listAllFilesInDir(".");
        String userFileName = requestFileAndName();
        OutputFileToConsole(userFileName);
        appendUserInputToFile(userFileName);
    }
    
    public static void listAllFilesInDir(String pathToDir) {
        File folder = new File(pathToDir);
        if (!folder.isDirectory()) {
            System.out.println("Заданный путь не является корректным путем до директории.");
        }
        System.out.println("Текущая директория: " + folder.getAbsolutePath() + ".\nОна содержит следующие текстовые файлы:");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };
        for (File file : folder.listFiles(fileFilter)) {
            System.out.printf("%s\n", file.getName());
        }
    }

    public static String requestFileAndName() {
        String filename;
        System.out.println("Введите имя файла, с которым следует работать:");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
            filename = reader.readLine();
            if (filename.isEmpty()) {
                throw new IOException("Имя файла не может быть пустым.");
            }
            File usersFile = new File(filename);
            if (usersFile.exists() && usersFile.isFile()) {
                System.out.println("Файл с именем '" + filename + "' существует.");
            } else {
                Boolean isFileCreated = usersFile.createNewFile();
                System.out.println("Файл с именем '" + filename + "' не существует. Создан новый файл с указанным именем.");
            }
            return usersFile.getName();
        } catch (IOException ioe) {
            ioe.getMessage();
            ioe.printStackTrace();
        }
        return null;
    }

    public static void OutputFileToConsole(String filename) {
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(filename))) {
            int n = in.read();
            while (n != -1) {
                sb.append((char)n);
                n = in.read();
            }
            System.out.printf("Содержимое файла '%s':\n%s\n", filename, sb.toString());
        } catch (IOException ioe) {
            ioe.getMessage();
            ioe.printStackTrace();
        }
    }
    
    public static void appendUserInputToFile(String filename) {
        String userStr;
        System.out.printf("Введите текстовую строку для записи в файл '%s'.\n", filename);
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            userStr = reader.readLine();
            if (!userStr.isEmpty()) {
                
                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filename, true))) {
                    byte[] buffer = userStr.getBytes(StandardCharsets.UTF_8);
                    out.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            } 
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
}