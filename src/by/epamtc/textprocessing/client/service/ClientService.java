package by.epamtc.textprocessing.client.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientService {
    private BufferedReader reader;

    private static void showMenu() {
        System.out.println("\n----- Программа для работы с текстовым файлом -----\n");
        System.out.println("Выберите действие, которое необходимо выполнить с текстовым файлом:");
        System.out.println("1 - Поиск предложений в тексте, в которых есть одинаковые слова.");
        System.out.println("2 - Поиск и печать (без повторений, во всех вопросительных предложениях текста) слов заданной длины.");
        System.out.println("3 - Сортировка предложений текста по количеству слов в них.");
        System.out.println("4 - Выход из приложения\n");
    }

    public String getClientRequest() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            showMenu();
            System.out.print("Выберите операцию над текстом: ");

            String userAction = reader.readLine();
            switch (userAction) {
                case "1":
                    return "sentencesWithSameWords";
                case "2": {
                    String wordLength = getWordLength();
                    String delimiter = "#";
                    return wordLength + delimiter + "wordsOfGivenLengthInInterrogativeSentence";
                }
                case "3":
                    return "sortedSentencesByCountOfWords";
                case "4":
                    return "exit";
                default:
                    System.out.print("Некорректный ввод. Попробуйте еще раз: ");
            }
        } while (true);
    }

    private String getWordLength() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String wordLength = null;
        boolean isEnterNumber = false;

        while (!isEnterNumber) {
            System.out.print("Введите длину слова: ");
            try {
                wordLength = reader.readLine();
                Integer.parseInt(wordLength);
                isEnterNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Введена некорректная длина слова! Повторите ввод.");
            }
        }
        return wordLength;
    }
}
