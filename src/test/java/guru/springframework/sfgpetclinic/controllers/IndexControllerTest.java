package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {
    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test proper display name")
    @Test
    void index() {
        assertEquals("index",indexController.index());

        /*текст повідомлення вискакує в консолі коли тест провальний */
        assertEquals("index",indexController.index(),"test not good");
    }

    @Test
    /*лямбда як спосіб передати повідомлення в консоль якщо тест не виконується, при виконанні тесту повідомлення не зявляється */
    void oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()),()->"This is buiding message for test");
    }
}