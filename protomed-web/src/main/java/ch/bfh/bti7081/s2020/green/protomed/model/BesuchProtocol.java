package ch.bfh.bti7081.s2020.green.protomed.model;

import ch.bfh.bti7081.s2020.green.protomed.management.PersistenceManager;
import lombok.Getter;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BesuchProtocol extends Protocol {

    @Getter
    private List<HealthService> serviceList = new ArrayList<>();

    public BesuchProtocol(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime creationDate, Appointment appointment) {
        super(healthVisitor, healthClient, creationDate, ProtocolType.BESUCH);
        this.appointment = appointment;
    }

    public BesuchProtocol(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime creationDate, Appointment appointment, String content) {
        super(healthVisitor, healthClient, creationDate, ProtocolType.BESUCH, content);
        this.appointment = appointment;
    }

    private void setServiceIds() {
        String[] ids = new String[serviceList.size()];
        for (int i = 0; i < serviceList.size(); i++) {
            ids[i] = serviceList.get(i).getServiceID();
        }
        serviceIds = ids;
        try {
            PersistenceManager.getInstance().getProtocolDao().update(this);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void addService(HealthService service) {
        this.serviceList.add(service);
        this.setServiceIds();
    }
}
