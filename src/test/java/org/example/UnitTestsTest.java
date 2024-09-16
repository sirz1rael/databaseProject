package org.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestsTest extends Connector {

    UnitTestsTest(List<User> data) {
        super(data);
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}