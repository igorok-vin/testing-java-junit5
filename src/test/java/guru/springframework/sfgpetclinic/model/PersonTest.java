package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void groupeAssertions() {
        //given
        Person person = new Person(1l,"Joe","Buck");

        //then
        /*робимо серію тверджень через лямбду*/
        assertAll("Test Props Set",
                ()-> assertEquals("Joe", person.getFirstName()),
                ()-> assertEquals("Buck", person.getLastName()),
                ()-> assertEquals(Long.valueOf(1) ,person.getId()));/*якщо просто 1 а не Long.valueOf(1) то помилка*/
    }
}