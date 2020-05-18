package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.management.mock.AppointmentMock;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;

import java.util.List;
import java.util.stream.Collectors;

public class PersistenceManager {

    // Singleton
    private static PersistenceManager instance;

    public static PersistenceManager getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new PersistenceManager();
        }
        return instance;
    }

    private PersistenceManager() {}

    public List<Appointment> getAppointments() {
        // TODO: Implement DB Query
        return AppointmentMock.getAppointments();
    }

    public List<Appointment> getAppointmentsByHealthVisitorID(Integer userid) {
        return AppointmentMock.getAppointments().stream().filter(appointment -> appointment.getHealthVisitor().getPersonId() == userid).collect(Collectors.toList());
    }

    public List<Appointment> getAppointmentsByHealthClientID(Integer userid) {
        return AppointmentMock.getAppointments().stream().filter(appointment -> appointment.getHealthClient().getPersonId() == userid).collect(Collectors.toList());
    }



}
