package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.management.mock.AppointmentMock;
import ch.bfh.bti7081.s2020.green.protomed.management.mock.ProtocolMock;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class PersistenceManager {

    public enum PersistenceStrategy {
        PERSISTENCE_STRATEGY_MOCK_DATA,
        PERSISTENCE_STRATEGY_SQLITE,
    }

    // Singleton
    private static PersistenceManager instance;

    private final PersistenceStrategy persistenceStrategy = PersistenceStrategy.PERSISTENCE_STRATEGY_MOCK_DATA;

    private final static String kSQLiteConnectionURL = "jdbc:sqlite:persistenceStore.db";
    private final static String kMemoryConnectionURL = "jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1";

    private JdbcConnectionSource connectionSource;
    private Dao<Appointment, Integer> appointmentDao;
    private Dao<Protocol, Integer> protocolDao;

    public static PersistenceManager getInstance() {
        if (instance == null) {
            instance = new PersistenceManager();
        }
        return instance;
    }

    private PersistenceManager() {
    }

    public void configureInstance() throws Exception {
        initializeAndConnectDB();
        appointmentDao = DaoManager.createDao(connectionSource, Appointment.class);
        protocolDao = DaoManager.createDao(connectionSource, Protocol.class);

        if (persistenceStrategy == PersistenceStrategy.PERSISTENCE_STRATEGY_MOCK_DATA) {
            loadAppointmentsFromMockData();
            loadProtocolsFromMockData();
        }
    }

    private void initializeAndConnectDB() throws SQLException {
        this.connectionSource = new JdbcConnectionSource(connectionURL());
        TableUtils.createTableIfNotExists(connectionSource, Appointment.class);
        TableUtils.createTableIfNotExists(connectionSource, Protocol.class);
    }

    public void shutdown() {
        try {
            if (connectionSource != null) {
                connectionSource.close();
                connectionSource = null;
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private String connectionURL() {
        if (persistenceStrategy == PersistenceStrategy.PERSISTENCE_STRATEGY_SQLITE)
            return kSQLiteConnectionURL;
        else if (persistenceStrategy == PersistenceStrategy.PERSISTENCE_STRATEGY_MOCK_DATA)
            return kMemoryConnectionURL;
        else
            return "";
    }

    private void loadAppointmentsFromMockData() {
        for (Appointment appointment : AppointmentMock.getAppointments()) {
            try {
                appointmentDao.create(appointment);
            } catch (SQLException exception) {
                ///TODO: EXCEPTION HANDLING
                System.out.println(exception.getMessage());
            }
        }
    }

    private void loadProtocolsFromMockData() {
        for (Protocol protocol : ProtocolMock.getProtocols()) {
            try {
                protocolDao.create(protocol);
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public Dao<Protocol, Integer> getProtocolDao() {
        return protocolDao;
    }

    public Dao<Appointment, Integer> getAppointmentDao() {
        return appointmentDao;
    }
}
