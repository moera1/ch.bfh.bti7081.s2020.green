package ch.bfh.bti7081.s2020.green.protomed.management.mock;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthServiceManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProtocolMock {

    public static List<Protocol> getProtocols() {

        List<Protocol> protocols = new ArrayList<>();
        LocalDateTime time = LocalDateTime.now();
        List<HealthService> healthServices = new ArrayList<>(HealthServiceManager.getInstance().getHealthServices());

        HealthVisitor laura = HealthVisitorManager.getInstance().getHealthVisitor(1);
        HealthVisitor gertrud = HealthVisitorManager.getInstance().getHealthVisitor(2);
        HealthVisitor max = HealthVisitorManager.getInstance().getHealthVisitor(3);

        HealthClient daniel = HealthClientManager.getInstance().getHealthClient(1);
        HealthClient thomas = HealthClientManager.getInstance().getHealthClient(2);
        HealthClient lars = HealthClientManager.getInstance().getHealthClient(3);

        // Protocols of Laura
        List<Appointment> lauraAppointments = ApplicationModelManager.getInstance().getAppointmentsByHealthVisitorID(laura.getPersonId());

        protocols.add(new Protocol(laura, daniel, time, ProtocolType.NOTIZ, "Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.\n\n Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.\n\n Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat."));
        protocols.add(new BesuchProtocol(laura, daniel, lauraAppointments.get(0).getTime(), lauraAppointments.get(0), "This is the first protocol."));
        protocols.add(new BesuchProtocol(laura, daniel, lauraAppointments.get(1).getTime(), lauraAppointments.get(1)));
        protocols.add(new BesuchProtocol(laura, daniel, lauraAppointments.get(2).getTime(), lauraAppointments.get(2), "This is the third protocol."));
        protocols.add(new BesuchProtocol(laura, daniel, lauraAppointments.get(3).getTime(), lauraAppointments.get(3)));
        protocols.add(new BesuchProtocol(laura, thomas, lauraAppointments.get(4).getTime(), lauraAppointments.get(4)));
        protocols.add(new Protocol(laura, daniel, time, ProtocolType.TELEFON));

        // Protocols of Gertrud
        List<Appointment> gertrudAppointments = ApplicationModelManager.getInstance().getAppointmentsByHealthVisitorID(gertrud.getPersonId());

        protocols.add(new BesuchProtocol(gertrud, lars, gertrudAppointments.get(0).getTime(), gertrudAppointments.get(0), "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis."));
        BesuchProtocol p3 = new BesuchProtocol(gertrud, lars, gertrudAppointments.get(1).getTime(), gertrudAppointments.get(1), "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.");
        p3.addService(healthServices.get(1));
        protocols.add(p3);
        protocols.add(new Protocol(gertrud, lars, time.minusDays(8), ProtocolType.TELEFON));
        protocols.add(new BesuchProtocol(gertrud, lars, gertrudAppointments.get(2).getTime(), gertrudAppointments.get(2),"Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.\n\n Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat."));
        BesuchProtocol p2 = new BesuchProtocol(gertrud, lars, gertrudAppointments.get(3).getTime(), gertrudAppointments.get(3), "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.");
        p2.addService(healthServices.get(0));
        p2.addService(healthServices.get(3));
        p2.addService(healthServices.get(4));
        protocols.add(p2);
        BesuchProtocol p4 = new BesuchProtocol(gertrud, daniel, gertrudAppointments.get(4).getTime(), gertrudAppointments.get(4), "Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.\n\n Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.\n\n Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.");
        p4.addService(healthServices.get(3));
        p4.addService(healthServices.get(6));
        protocols.add(p4);
        protocols.add(new Protocol(gertrud, lars, time.minusDays(3), ProtocolType.NOTIZ, "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi."));
        protocols.add(new Protocol(gertrud, lars, time.minusDays(18), ProtocolType.NOTIZ, "At accusam aliquyam diam diam dolore dolores duo eirmod eos erat, et nonumy sed tempor et et invidunt justo labore Stet clita ea et gubergren, kasd magna no rebum.\n\n sanctus sea sed takimata ut vero voluptua.\n\n est Lorem ipsum dolor sit amet.\n\n Lorem ipsum dolor sit amet, consetetur."));



        // Protocols of Max
        List<Appointment> maxAppointments = ApplicationModelManager.getInstance().getAppointmentsByHealthVisitorID(max.getPersonId());

        BesuchProtocol p1 = new BesuchProtocol(max, thomas, time, maxAppointments.get(0), "This is the first protocol with a Service.");
        p1.addService(healthServices.get(0));
        p1.addService(healthServices.get(1));
        protocols.add(p1);
        protocols.add(new BesuchProtocol(max, thomas, time, maxAppointments.get(1), "This is an example."));
        protocols.add(new BesuchProtocol(max, lars, time, maxAppointments.get(2), "This is an example."));
        protocols.add(new BesuchProtocol(max, lars, time, maxAppointments.get(3), "This is an example."));
        protocols.add(new BesuchProtocol(max, lars, time, maxAppointments.get(4), "This is an example."));
        protocols.add(new BesuchProtocol(max, daniel, time, maxAppointments.get(5), "This is an example."));


        return protocols;
    }

}
