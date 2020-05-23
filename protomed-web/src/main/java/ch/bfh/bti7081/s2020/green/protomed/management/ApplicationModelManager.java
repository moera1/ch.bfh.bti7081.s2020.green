package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;

import java.sql.SQLException;
import java.util.List;

public class ApplicationModelManager {

    // Singleton
    private static ApplicationModelManager instance;

    public static ApplicationModelManager getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new ApplicationModelManager();
        }
        return instance;
    }

    private ApplicationModelManager() {
    }

    private PersistenceManager persistenceManager(){
        return PersistenceManager.getInstance();
    }

    public List<Protocol> getProtocols() {
        return persistenceManager().fetchAllProtocols();
    }

    public List<Protocol> getProtocolsByHealthClientID(int id) {
        return persistenceManager().fetchAllProtocolsByClientID(id);
    }

    public List<Protocol> getProtocolsByHealthVisitorID(int id) {
        return persistenceManager().fetchAllProtocolsByVisitorID(id);
    }

    public boolean createProtocol(Protocol protocol){
        try {
            persistenceManager().getProtocolDao().create(protocol);
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean saveProtocol(Protocol protocol){
        try {
            persistenceManager().getProtocolDao().update(protocol);
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean deleteProtocol(Protocol protocol){
        try {
            persistenceManager().getProtocolDao().delete(protocol);
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public List<Appointment> getAppointments() {
        return persistenceManager().fetchAllAppointments();
    }

    public List<Appointment> getAppointmentsByHealthVisitorID(Integer userid) {
        return persistenceManager().fetchAppointmentsByVisitorID(userid);
    }

    public List<Appointment> getAppointmentsByHealthClientID(Integer userid) {
        return persistenceManager().fetchAppointmentsByClientID(userid);
    }

}
