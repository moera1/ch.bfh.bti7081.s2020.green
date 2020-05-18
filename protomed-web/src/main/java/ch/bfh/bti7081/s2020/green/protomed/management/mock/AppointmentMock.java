package ch.bfh.bti7081.s2020.green.protomed.management.mock;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentMock {

    public static List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        LocalDateTime time = LocalDateTime.now();

        HealthVisitor laura = HealthVisitorManager.getInstance().getHealthVisitor(1);
        HealthVisitor gertrud = HealthVisitorManager.getInstance().getHealthVisitor(2);
        HealthVisitor max = HealthVisitorManager.getInstance().getHealthVisitor(3);

        HealthClient daniel = HealthClientManager.getInstance().getHealthClient(1);
        HealthClient thomas = HealthClientManager.getInstance().getHealthClient(2);
        HealthClient lars = HealthClientManager.getInstance().getHealthClient(3);

        // Appointments of laura
        appointments.add(new Appointment(laura, daniel, time.plusDays(1)));
        appointments.add(new Appointment(laura, daniel, time.plusDays(2)));
        appointments.add(new Appointment(laura, daniel, time.plusDays(3).plusHours(4)));
        appointments.add(new Appointment(laura, daniel, time.plusDays(4)));
        appointments.add(new Appointment(laura, thomas, time.plusDays(1).minusHours(1)));

        // Appointments of gertrud
        appointments.add(new Appointment(gertrud, lars, time.plusDays(1).minusHours(2)));
        appointments.add(new Appointment(gertrud, lars, time.plusDays(2)));
        appointments.add(new Appointment(gertrud, lars, time.plusDays(3)));
        appointments.add(new Appointment(gertrud, lars, time.plusDays(4)));

        // Appointments of max
        appointments.add(new Appointment(max, thomas, time.plusDays(1).plusHours(5)));
        appointments.add(new Appointment(max, thomas, time.plusDays(2)));
        appointments.add(new Appointment(max, lars, time.plusDays(2)));
        appointments.add(new Appointment(max, lars, time.plusDays(2).plusHours(12)));
        appointments.add(new Appointment(max, lars, time.plusDays(3)));
        appointments.add(new Appointment(max, daniel, time.plusDays(6).minusHours(5)));

        return appointments;
    }

}
