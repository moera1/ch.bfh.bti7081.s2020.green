package ch.bfh.bti7081.s2020.green.protomed.model;


import java.time.LocalDate;
import java.util.Date;

public class HealthClient extends Person {

    public HealthClient(int personId, Address address, String name, String firstname, LocalDate birthDate) {
        super(personId, address, name, firstname, birthDate);
    }
}
