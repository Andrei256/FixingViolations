package com.myproject.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOService {

    private static final String MENU = "\n" + "1. Зафиксировать нарушение\n" + "2. Добавить водителя\n"
            + "3. Добавить машину\n" + "4. Добавить новый вид нарушения\n" +
            "5. Показать нарушения\n" + "6. Прощаем(но не всё)\n";

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void printMainMenu() {
        System.out.println(MENU);
    }

    public String getInputString() throws IOException {
        return reader.readLine();
    }
    public int getInputInt() throws IOException, NumberFormatException {
        return Integer.parseInt(getInputString());
    }
}
