package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentManager {

    @Getter
    private List<Appointment> appointments;

    // Singleton
    private static AppointmentManager instance;

    public static AppointmentManager getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new AppointmentManager();
        }
        return instance;
    }

    private AppointmentManager() {
        appointments = PersistenceManager.getInstance().loadAppointments();
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Appointment> getAppointmentsByHealthVisitorID(Integer userid) {
        return appointments.stream().filter(appointment -> appointment.getHealthVisitor().getPersonId() == userid).collect(Collectors.toList());
    }

    public List<Appointment> getAppointmentsByHealthClientID(Integer userid) {
        return appointments.stream().filter(appointment -> appointment.getHealthClient().getPersonId() == userid).collect(Collectors.toList());
    }


}
