package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//     Задача от НИКИТИНА
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String adress = reader.readLine();

        UrlValidator urlValidator = new UrlValidator();
            if (urlValidator.isValid(adress)) {
                System.out.println(" - Сайт существует");
            } else {
                System.out.println(" - Такого сайта нет");
        }
    }
}



