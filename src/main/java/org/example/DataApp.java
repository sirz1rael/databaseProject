package org.example;

import java.util.List;
import java.util.Scanner;

public class DataApp {
    Scanner scanner = new Scanner(System.in);

    private final String[] menuList = {
            "1. Вывести всю информацию из таблицы",
            "2. Добавить информацию в таблицу",
            "3. Удалить информацию в таблицу",
            "0. Завершить работу программы"
    };

    Connector connector = new Connector();

    private void clearConsole() {
        try {
            ProcessBuilder pb = new ProcessBuilder("clear");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public boolean setup(){
        System.out.println("ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ");
        System.out.print("LOGIN: ");
        String login = scanner.nextLine();
        System.out.print("PASSWORD: ");
        String password = scanner.nextLine();
        System.out.print("CONNECTION LINK: ");
        String connection_link = scanner.nextLine();

        if (connector.connect(login, password, connection_link)) {
            System.out.println("Connected.");
            appLoop();
            return true;
        } else {
            System.out.println("Connection failed.");
            System.exit(1);
            return false;
        }
    }

    public int appLoop() {
        clearConsole();
        for (String s : menuList) {
            System.out.println(s);
        }
        int pickedValue = scanner.nextInt();

        switch (pickedValue) {
            case 1:
                clearConsole();
                for (int i = 0; i < connector.showData().size(); i++) {
                    System.out.println(connector.showData().get(i).ID
                    + " " + connector.showData().get(i).SURNAME
                    + " " + connector.showData().get(i).NAME
                    + " " + connector.showData().get(i).BIRTH_DATE);
                }
                break;
            case 2:
                clearConsole();
                System.out.println("Введите данные для новой строки: \n" + "Имя: ");
                String name = scanner.next();
                clearConsole();
                System.out.println("Фамилия: ");
                String surname = scanner.next();
                clearConsole();
                System.out.println("Порядковый номер: ");
                int id = scanner.nextInt();
                clearConsole();
                System.out.println("Дата рождения: ");
                String bDate = scanner.next();

                connector.insertValue(new User(name, surname, id, bDate));
                break;
            case 3:
                clearConsole();
                System.out.println("Введите номер строки, которую хотите удалить: ");
                int index = scanner.nextInt();

                connector.deleteValue(index);
                break;
            case 0:
                clearConsole();
                System.exit(0);
        }
        return appLoop();
    }
}
