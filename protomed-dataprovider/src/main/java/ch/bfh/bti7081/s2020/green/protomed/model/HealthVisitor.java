package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
public class HealthVisitor extends Person {

    private final @NonNull
    BigInteger employeeID;
    private final @NonNull
    String email;
    private final @NonNull
    String password;
    private final @NonNull
    boolean isSupervisor;

    @Builder
    public HealthVisitor(
            String name,
            String firstname,
            Adress adress,
            LocalDate birthdate,
            String phoneNumber,
            BigInteger employeeID,
            String email,
            String password,
            boolean isSupervisor) {
        super(name, firstname, adress, birthdate, phoneNumber);
        this.employeeID = employeeID;
        this.email = email;
        this.password = password;
        this.isSupervisor = isSupervisor;
    }


}
