package br.com.devviniciusprado;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;

    @Test
    void testMain() {
        main = new Main();
        assertNotNull(main, "Main class should not be null");
    }
}