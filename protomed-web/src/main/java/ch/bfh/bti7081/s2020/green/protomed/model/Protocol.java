package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Protocol {

    @Getter
    private final HealthVisitor healthVisitor;
    @Getter
    private final HealthClient healthClient;
    @Getter @Setter
    private String content;
    @Getter
    private final LocalDateTime creationDate;
    @Getter
    private final ProtocolType protocolType;

    public Protocol(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime creationDate, ProtocolType protocolType) {
        this.healthVisitor = healthVisitor;
        this.healthClient = healthClient;
        this.creationDate = creationDate;
        this.protocolType = protocolType;
    }

    public Protocol(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime creationDate, ProtocolType protocolType, String content) {
        this.healthVisitor = healthVisitor;
        this.healthClient = healthClient;
        this.creationDate = creationDate;
        this.protocolType = protocolType;
        this.content = content;
    }

}
