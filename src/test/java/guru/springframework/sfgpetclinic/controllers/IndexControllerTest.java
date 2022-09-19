package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

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

    @Test
    void errorHandler() {
        assertThrows(ValueNotFoundException.class,()->{
            indexController.errorHandler();
        });
    }

     /*AssertTimeout method counts the time we give, if our test method takes
     longer than specified, this test will fail after all operations
     are completed.*/
    @Test
    void testTimeOut() throws InterruptedException {
        assertTimeout(Duration.ofMillis(100),()-> Thread.sleep(2000));
    }

    /* assertTimeoutPreemptively method takes longer than specified,
    this method will fail immediately. And it won’t wait for all the
    processes to be completed.*/
    @Test
    void testTimePrempt() throws InterruptedException {
        assertTimeoutPreemptively(Duration.ofMillis(100),()-> Thread.sleep(2000));
    }
}