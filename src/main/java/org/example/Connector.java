package org.example;

import java.util.ArrayList;
import java.util.List;

public class Connector implements ConnectionDB {

    private final List<User> DATA = new ArrayList<>();


    @Override
    public List<User> showData() {
        return DATA;
    }

    @Override
    public void insertValue(User user) {
        DATA.addFirst(user);
    }

    @Override
    public void deleteValue(int index) {
        DATA.remove(index);
    }
}
