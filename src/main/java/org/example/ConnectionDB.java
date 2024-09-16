package org.example;

import java.util.List;

public interface ConnectionDB {

    String ADMIN_LOGIN = "admin";
    String ADMIN_PASSWORD = "1234";
    String CONNECTION_LINK = "jdbc:postgresql://localhost:5432/users_db";

    default boolean connect(String login, String password, String connection_link) {
        return login.equals(ADMIN_LOGIN)
                && password.equals(ADMIN_PASSWORD)
                && connection_link.equals(CONNECTION_LINK);
    }

    void insertValue(User user);
    void deleteValue(int index);
    List<User> showData();
}
