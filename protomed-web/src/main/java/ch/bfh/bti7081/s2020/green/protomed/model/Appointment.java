package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.Getter;

import java.time.LocalDateTime;

public class Appointment {

    @Getter
    private HealthVisitor healthVisitor;
    @Getter
    private HealthClient healthClient;
    @Getter
    private LocalDateTime time;

    public Appointment(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime time) {
        this.healthVisitor = healthVisitor;
        this.healthClient = healthClient;
        this.time = time;
    }

}
