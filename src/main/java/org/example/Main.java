package org.example;

/*
#ЗАДАНИЕ
Реализовать интерфейс ConnectionDB, в котором указаны методы:
connect(), insertValue(), deleteValue(), showData().
Поля в интерфейсе: ADMIN_LOGIN = "admin" ADMIN_PASSWORD = "1234"
CONNECTION_LINK = "jdbc:postgresql://localhost:5432/users_db"
У метода connect() пропишите default реализацию по следующей логике:
Подключение происходит по ссылке CONNECTION_LINK, далее проверяется корректность
ADMIN_LOGIN И ADMIN_PASSWORD, возвращает true, если соединение успешно и false, если подключение не установлено.
Создайте реализацию интерфейса ConnectionDB - Connector, который реализует методы интерфейса.
У него есть поле List<User› data, в котором хранится объект User(name, surname, id, birthDate).
Реализуйте методы добавления, удаления и вывода данных из этого поля.
 */

public class Main{
    public static void main(String[] args) {
        DataApp dp = new DataApp();
        dp.setup();
    }
}