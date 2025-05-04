package main.java.ru.otus.java.basic.homeworks.homework28;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HomeWork {

    public static void main(String[] args) {
        String userFileName = requestUserForFileAndName();
        if (userFileName == null || userFileName.trim().isEmpty()) {
            System.err.println("Ошибка: Не задано имя файла для чтения. Завершение работы.");
            return;
        }
        String userSearchStr = requestUserForSearchString();
        if (userSearchStr == null || userSearchStr.trim().isEmpty()) {
            System.out.println("Ошибка: Не задана последовательность символов для поиска в файле. Завершение работы.");
            return;
        }
        String fileDataStr = readFileToStr(userFileName);
        if (fileDataStr == null || fileDataStr.isEmpty()) {
            System.out.println("Данные считанные из указанного файла пусты. Поиск подстроки невозможен. Завершение работы.");
            return;
        }
        System.out.println("Выполняется поиск в указанном файле последовательности символов: '" + userSearchStr + "'");
        /*
        String[] dataStrParts = fileDataStr.split(userSearchStr);
        if (dataStrParts.length < 2) {
            System.out.println("Не найдено ни одного вхождения искомой последовательности символов в указанном файле.");
        }
        int searchStrCount = dataStrParts.length - 1;
        */
        int searchStrCount = (fileDataStr.length() - fileDataStr.replace(userSearchStr, "").length()) / userSearchStr.length();
        System.out.println("Количество вхождений искомой последовательности символов в указанном файле: "+searchStrCount);
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
                    System.out.println("Файл с именем '" + filename + "' не существует, но существует директория с таким именем." +
                            "Задайте другое имя файла.");
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

    public static String requestUserForSearchString() {
        System.out.println("Введите последовательность символов, поиск которой будет выполняться в файле:");
        Scanner scanner = new Scanner(System.in);
        String searchStr = scanner.nextLine();
        if (searchStr == null || searchStr.isEmpty()) {
            return null;
        }
        return searchStr;
    }

    public static String readFileToStr(String filename) {
        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            byte[] buffer = fileInputStream.readAllBytes();
            return new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}
