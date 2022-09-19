package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {
    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test proper display name")
    @Test
    void index() {
        assertEquals("index", indexController.index());

        /*текст повідомлення вискакує в консолі коли тест провальний */
        assertEquals("index", indexController.index(), "test not good");

        /*бібліотека assertj. результат той же але з цієї бібліотеки
        додаткові можливості. assertThat - є і в іншій бібліотеці Hamcrest*/
        assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
        /*лямбда як спосіб передати повідомлення в консоль якщо тест не виконується, при виконанні тесту повідомлення не зявляється */
    void oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()), () -> "This is buiding message for test");
    }

    @Test
    void errorHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            indexController.errorHandler();
        });
    }

    /*AssertTimeout method counts the time we give, if our test method takes
    longer than specified, this test will fail after all operations
    are completed.*/
    @Disabled
    @Test
    void testTimeOut() throws InterruptedException {
        assertTimeout(Duration.ofMillis(2000), () -> Thread.sleep(5000));
    }

    /* assertTimeoutPreemptively method takes longer than specified,
    this method will fail immediately. And it won’t wait for all the
    processes to be completed.*/
    @Disabled
    @Test
    void testTimePrempt() throws InterruptedException {
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> Thread.sleep(5000));
    }

    /*Failed assumptions do not result in a test failure; rather, a failed
    assumption results in a test being aborted. Assumption basically means
    “don't run this test if these conditions don't apply”. Assumptions are
    typically used whenever it does not make sense to continue execution
    of a given test method — for example, if the test depends on something
    that does not exist in the current runtime environment.*/
    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    /* Conditional JUnit Test Execution*/
    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "username", matches = "sdf")
    @Test
    void testIfUserJT() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred() {
    }


}