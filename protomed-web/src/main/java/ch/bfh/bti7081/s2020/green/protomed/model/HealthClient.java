package ch.bfh.bti7081.s2020.green.protomed.model;


import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class HealthClient extends Person {

    private HealthVisitor healthVisitor;
    @Getter
    private List<HealthService> insuredServices;

    public HealthClient(HealthVisitor healthVisitor, List<HealthService> insuredServices, int personId, Address address, String name, String firstname, LocalDate birthDate, String phoneNumber, String profilePicture) {
        super(personId, address, name, firstname, birthDate, phoneNumber, profilePicture);
        this.healthVisitor = healthVisitor;
        this.insuredServices = insuredServices;
    }
}
