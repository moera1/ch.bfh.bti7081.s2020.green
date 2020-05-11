package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Getter
public class HealthClient extends Person {

    private final @NonNull BigInteger clientID;
    private final @NonNull Integer healthVisitorID;
    private final @NonNull List<HealthService> insuredServices;

    @Builder
    public HealthClient(
            String name,
            String firstname,
            Address address,
            LocalDate birthdate,
            String phoneNumber,
            BigInteger clientID,
            List<HealthService> insuredServices,
            Integer healthVisitorID) {
        super(name, firstname, address, birthdate, phoneNumber);
        this.clientID = clientID;
        this.insuredServices = insuredServices;
        this.healthVisitorID = healthVisitorID;
    }
}
