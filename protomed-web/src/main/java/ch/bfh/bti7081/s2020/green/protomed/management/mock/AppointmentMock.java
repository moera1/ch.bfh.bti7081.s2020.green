package ch.bfh.bti7081.s2020.green.protomed.management.mock;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class AppointmentMock {

    public static List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        LocalDateTime time = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);

        HealthVisitor laura = HealthVisitorManager.getInstance().getHealthVisitor(1);
        HealthVisitor gertrud = HealthVisitorManager.getInstance().getHealthVisitor(2);
        HealthVisitor max = HealthVisitorManager.getInstance().getHealthVisitor(3);

        HealthClient daniel = HealthClientManager.getInstance().getHealthClient(1);
        HealthClient thomas = HealthClientManager.getInstance().getHealthClient(2);
        HealthClient lars = HealthClientManager.getInstance().getHealthClient(3);

        // Appointments of laura
        if (laura != null) {
            appointments.add(new Appointment(laura, daniel, time.plusDays(2)));
            appointments.add(new Appointment(laura, daniel, time.plusDays(5).plusMinutes(30)));
            appointments.add(new Appointment(laura, daniel, time.plusDays(8).plusHours(4)));
            appointments.add(new Appointment(laura, daniel, time.plusDays(10).plusHours(4).plusMinutes(30)));
            appointments.add(new Appointment(laura, thomas, time.plusDays(1).minusHours(1)));
        }

        // Appointments of gertrud
        if (gertrud != null) {
            appointments.add(new Appointment(gertrud, lars, time.plusDays(4).minusHours(2)));
            appointments.add(new Appointment(gertrud, lars, time.plusDays(2)));
            appointments.add(new Appointment(gertrud, lars, time.plusDays(5).plusHours(2).plusMinutes(30)));
            appointments.add(new Appointment(gertrud, lars, time.plusDays(12)));
            appointments.add(new Appointment(gertrud, lars, time.plusDays(24).plusHours(3).plusMinutes(15)));
            appointments.add(new Appointment(gertrud, lars, time.plusDays(45).plusHours(1).plusMinutes(30)));
        }

        // Appointments of max
        if (max != null) {
            appointments.add(new Appointment(max, thomas, time.plusDays(1).plusHours(5)));
            appointments.add(new Appointment(max, thomas, time.plusDays(5).plusHours(4).plusMinutes(30)));
            appointments.add(new Appointment(max, lars, time.plusDays(8)));
            appointments.add(new Appointment(max, lars, time.plusDays(25).plusHours(12)));
            appointments.add(new Appointment(max, lars, time.plusDays(31).plusHours(4).plusMinutes(30)));
            appointments.add(new Appointment(max, daniel, time.plusDays(45).minusHours(5)));
        }

        return appointments;
    }

}
