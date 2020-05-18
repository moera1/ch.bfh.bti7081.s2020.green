package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.management.mock.AppointmentMock;
import ch.bfh.bti7081.s2020.green.protomed.management.mock.ProtocolMock;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;

import java.util.List;

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

    private PersistenceManager() {
    }

    public List<Appointment> loadAppointments() {
        // TODO: Implement DB Query
        return AppointmentMock.getAppointments();
    }

    public void saveAppointments(List<Appointment> appointments) {
        // TODO: Implement DB Query
    }

    public void saveAppointment(Appointment appointment) {
        // TODO: Implement DB Query
    }

    public List<Protocol> loadProtocols() {
        // TODO: Implement DB Query
        return ProtocolMock.getProtocols();
    }

}
