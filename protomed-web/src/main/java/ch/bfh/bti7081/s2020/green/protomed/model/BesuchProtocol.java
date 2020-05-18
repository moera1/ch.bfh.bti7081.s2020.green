package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class BesuchProtocol extends Protocol {

    @Getter
    private final Appointment appointment;
    @Getter
    private List<HealthService> serviceList;

    public BesuchProtocol(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime creationDate, Appointment appointment) {
        super(healthVisitor, healthClient, creationDate, ProtocolType.BESUCH);
        this.appointment = appointment;
    }

    public BesuchProtocol(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime creationDate, Appointment appointment, String content) {
        super(healthVisitor, healthClient, creationDate, ProtocolType.BESUCH, content);
        this.appointment = appointment;
    }

    public void addService(HealthService service) {
        this.serviceList.add(service);
    }
}
