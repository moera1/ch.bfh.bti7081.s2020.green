package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.Null;
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
    private final @Null
    Integer supervisorID;

    @Builder
    public HealthVisitor(
            String name,
            String firstname,
            Address address,
            LocalDate birthdate,
            String phoneNumber,
            String profilePicture,
            BigInteger employeeID,
            String email,
            String password,
            Integer superVisorID) {
        super(name, firstname, address, birthdate, phoneNumber, profilePicture);
        this.employeeID = employeeID;
        this.email = email;
        this.password = password;
        this.supervisorID = superVisorID;
    }


}
