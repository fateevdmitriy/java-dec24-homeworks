package ru.otus.java.basic.homeworks.homework19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        listAllFilesInDir(".");
        String userFileName = requestUserForFileAndName();
        outputFileToConsole(userFileName);
        appendUserInputToFile(userFileName);
        outputFileToConsole(userFileName);
    }

    public static void listAllFilesInDir(String pathToDir) {
        File folder = new File(pathToDir);
        if (!folder.isDirectory()) {
            System.out.println("Заданный путь не является корректным путем до существующей директории.");
            return;
        }
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };
        if (folder.listFiles(fileFilter) == null) {
            System.out.println("Не удалось вывести список текстовых файлов в директории, проверьте существует ли директория.");
            return;
        }
        System.out.println("Текущая директория: " + folder.getAbsolutePath() + ".\nОна содержит следующие текстовые файлы:");
        for (File file : folder.listFiles(fileFilter)) {
            System.out.printf("%s\n", file.getName());
        }
    }

    public static String requestUserForFileAndName() {
        String filename;
        System.out.println("Введите имя файла, с которым следует работать:");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            filename = bufferedReader.readLine();
            if (filename.isEmpty()) {
                throw new IllegalArgumentException("Имя файла не может быть пустым.");
            }
            File usersFile = new File(filename);
            if (usersFile.exists()) {
                if (usersFile.isFile()) {
                    System.out.println("Файл с именем '" + filename + "' существует.");
                } else if (usersFile.isDirectory()) {
                    System.out.println("Файл с именем '" + filename + "' не существует, но сушествует директория с таким именем.");
                    return null;
                } else {
                    System.out.println("Файл с именем '" + filename + "' не найден.");
                    return null;
                }
            } else {
                System.out.println("Файл с именем '" + filename + "' не существует.");
                boolean isFileCreated = usersFile.createNewFile();
                if (isFileCreated) {
                    System.out.println("Создан новый файл с именем '" + filename + "'.");
                } else {
                    return null;
                }
            }
            return usersFile.getName();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static void outputFileToConsole(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            int n = bufferedReader.read();
            while (n != -1) {
                sb.append((char) n);
                n = bufferedReader.read();
            }
            System.out.printf("Содержимое файла '%s':\n%s\n", filename, sb.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void appendUserInputToFile(String filename) {
        System.out.printf("Введите текстовую строку для записи в файл '%s'.\n", filename);
        Scanner scanner = new Scanner(System.in);
        String userStr = scanner.nextLine();
        if (userStr.isEmpty()) {
            System.out.println("Нечего записывать в файл, задана пустая строка для записи.");
            return;
        }
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filename, true))) {
            userStr += System.lineSeparator();
            byte[] buffer = userStr.getBytes(StandardCharsets.UTF_8);
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
