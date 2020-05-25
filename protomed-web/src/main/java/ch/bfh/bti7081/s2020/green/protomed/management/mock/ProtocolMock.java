package ch.bfh.bti7081.s2020.green.protomed.management.mock;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProtocolMock {

    public static List<Protocol> getProtocols() {

        List<Protocol> protocols = new ArrayList<>();
        LocalDateTime time = LocalDateTime.now();

        HealthVisitor laura = HealthVisitorManager.getInstance().getHealthVisitor(1);
        HealthVisitor gertrud = HealthVisitorManager.getInstance().getHealthVisitor(2);
        HealthVisitor max = HealthVisitorManager.getInstance().getHealthVisitor(3);

        HealthClient daniel = HealthClientManager.getInstance().getHealthClient(1);
        HealthClient thomas = HealthClientManager.getInstance().getHealthClient(2);
        HealthClient lars = HealthClientManager.getInstance().getHealthClient(3);

        // Protocols of Laura
        List<Appointment> lauraAppointments = ApplicationModelManager.getInstance().getAppointmentsByHealthVisitorID(laura.getPersonId());

        protocols.add(new Protocol(laura, daniel, time, ProtocolType.NOTIZ, "This is a test!"));
        protocols.add(new BesuchProtocol(laura, daniel, time, lauraAppointments.get(0), "This is the first protocol."));
        protocols.add(new BesuchProtocol(laura, daniel, time, lauraAppointments.get(1)));
        protocols.add(new BesuchProtocol(laura, daniel, time, lauraAppointments.get(2), "This is the third protocol."));
        protocols.add(new BesuchProtocol(laura, daniel, time, lauraAppointments.get(3)));
        protocols.add(new BesuchProtocol(laura, thomas, time, lauraAppointments.get(4)));
        protocols.add(new Protocol(laura, daniel, time, ProtocolType.TELEFON));

        // Protocols of Gertrud
        List<Appointment> gertrudAppointments = ApplicationModelManager.getInstance().getAppointmentsByHealthVisitorID(gertrud.getPersonId());

        protocols.add(new BesuchProtocol(gertrud, lars, time, gertrudAppointments.get(0), "This is the first protocol."));
        protocols.add(new BesuchProtocol(gertrud, lars, time, gertrudAppointments.get(1), "This is the second protocol."));
        protocols.add(new Protocol(gertrud, lars, time, ProtocolType.TELEFON));
        protocols.add(new BesuchProtocol(gertrud, lars, time, gertrudAppointments.get(2), "This is the third protocol."));
        protocols.add(new BesuchProtocol(gertrud, lars, time, gertrudAppointments.get(3), "This is the fourth protocol."));


        // Protocols of Max
        List<Appointment> maxAppointments = ApplicationModelManager.getInstance().getAppointmentsByHealthVisitorID(max.getPersonId());

        protocols.add(new BesuchProtocol(max, thomas, time, maxAppointments.get(0), "This is the first protocol."));
        protocols.add(new BesuchProtocol(max, thomas, time, maxAppointments.get(1), "This is an example."));
        protocols.add(new BesuchProtocol(max, lars, time, maxAppointments.get(2), "This is an example."));
        protocols.add(new BesuchProtocol(max, lars, time, maxAppointments.get(3), "This is an example."));
        protocols.add(new BesuchProtocol(max, lars, time, maxAppointments.get(4), "This is an example."));
        protocols.add(new BesuchProtocol(max, daniel, time, maxAppointments.get(5), "This is an example."));


        return protocols;
    }

}
