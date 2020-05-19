package ch.bfh.bti7081.s2020.green.protomed.model;


import java.time.LocalDate;

public class HealthClient extends Person {

    private HealthVisitor healthVisitor;

    public HealthClient(HealthVisitor healthVisitor, int personId, Address address, String name, String firstname, LocalDate birthDate, String phoneNumber, String profilePicture) {
        super(personId, address, name, firstname, birthDate, phoneNumber, profilePicture);
        this.healthVisitor = healthVisitor;
    }
}
