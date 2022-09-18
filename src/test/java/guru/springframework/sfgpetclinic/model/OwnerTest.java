package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest {
    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("133211223");

        /*одна чатисна інфо береться з Person а інша з Owner*/
        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(),"First name didnt match"),
                        () -> assertEquals("Buck", owner.getLastName(),"Last name didnt match")),
                () -> assertAll("Person Properties",
                        () -> assertEquals("Key West", owner.getCity(),"City didnt match"),
                        () -> assertEquals("133211223", owner.getTelephone()))
        );
    }
}