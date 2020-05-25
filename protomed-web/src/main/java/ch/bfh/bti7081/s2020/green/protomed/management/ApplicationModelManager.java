package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    private PersistenceManager persistenceManager() {
        return PersistenceManager.getInstance();
    }

    public List<Protocol> getProtocols() {
        try {
            return persistenceManager().getProtocolDao().queryForAll();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Optional<Protocol> getProtocolByID(int id) {
        try {
            return Optional.of(persistenceManager().getProtocolDao().queryForId(id));
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return Optional.empty();
        }
    }

    public List<Protocol> getProtocolsByHealthClientID(int id) {
        try {
            return persistenceManager().getProtocolDao().queryForEq("healthClientID", id);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Protocol> getProtocolsByHealthVisitorID(int id) {
        try {
            return persistenceManager().getProtocolDao().queryForEq("healthVisitorID", id);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public boolean createProtocol(Protocol protocol) {
        try {
            persistenceManager().getProtocolDao().create(protocol);
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean saveProtocol(Protocol protocol) {
        try {
            persistenceManager().getProtocolDao().update(protocol);
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean deleteProtocol(Protocol protocol) {
        try {
            persistenceManager().getProtocolDao().delete(protocol);
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public List<Appointment> getAppointments() {
        try {
            return persistenceManager().getAppointmentDao().queryForAll();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Appointment> getAppointmentsByHealthVisitorID(Integer userid) {
        try {
            return persistenceManager().getAppointmentDao().queryForEq("healthVisitorID", userid);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Appointment> getAppointmentsByHealthClientID(Integer userid) {
        try {
            return persistenceManager().getAppointmentDao().queryForEq("healthClientID", userid);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

}
