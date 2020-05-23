package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.management.mock.AppointmentMock;
import ch.bfh.bti7081.s2020.green.protomed.management.mock.ProtocolMock;
import ch.bfh.bti7081.s2020.green.protomed.model.*;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersistenceManager {

    public enum PersistenceStrategy {
        PERSISTENCE_STRATEGY_MOCK_DATA,
        PERSISTENCE_STRATEGY_SQLITE,
    }

    // Singleton
    private static PersistenceManager instance;

    private PersistenceStrategy persistenceStrategy = PersistenceStrategy.PERSISTENCE_STRATEGY_SQLITE;

    private final static String kSQLiteConnectionURL = "jdbc:sqlite:persistenceStore.db";
    private final static String kMemoryConnectionURL = "jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1";

    private JdbcConnectionSource connectionSource;
    private Dao<Appointment, Integer> appointmentDao;
    private Dao<Protocol, Integer> protocolDao;

    public static PersistenceManager getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new PersistenceManager();
        }
        return instance;
    }

    private PersistenceManager() {
    }

    public void configureInstance() throws Exception{
        this.initializeAndConnectDB(PersistenceStrategy.PERSISTENCE_STRATEGY_MOCK_DATA);

        appointmentDao = DaoManager.createDao(connectionSource, Appointment.class);
        protocolDao = DaoManager.createDao(connectionSource, Protocol.class);

        if (persistenceStrategy == PersistenceStrategy.PERSISTENCE_STRATEGY_MOCK_DATA) {
            loadAppointmentsFromMockData();
            loadProtocolsFromMockData();
        }
    }

    public void initializeAndConnectDB(PersistenceStrategy persistenceStrategy) throws SQLException{
        if (persistenceStrategy != null) this.persistenceStrategy = persistenceStrategy;

        this.connectionSource = new JdbcConnectionSource(connectionURL());

        TableUtils.createTableIfNotExists(connectionSource, Appointment.class);
        TableUtils.createTable(connectionSource, Protocol.class);
    }

    private String connectionURL(){
        if (persistenceStrategy == PersistenceStrategy.PERSISTENCE_STRATEGY_SQLITE)
            return kSQLiteConnectionURL;
        else if (persistenceStrategy == PersistenceStrategy.PERSISTENCE_STRATEGY_MOCK_DATA)
            return kMemoryConnectionURL;
        else
            return "";
    }

    public List<Appointment> fetchAllAppointments() {
        try {
            return appointmentDao.queryForAll();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Appointment> fetchAppointmentsByVisitorID(Integer userid) {
        try {
            return appointmentDao.queryForEq("healthVisitorID", userid);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Appointment> fetchAppointmentsByClientID(Integer userid) {
        try {
            return appointmentDao.queryForEq("healthClientID", userid);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Protocol> fetchAllProtocols() {
        try {
            return protocolDao.queryForAll();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Protocol> fetchAllProtocolsByVisitorID(Integer userid) {
        try {
            return protocolDao.queryForEq("healthVisitorID", userid);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Protocol> fetchAllProtocolsByClientID(Integer userid) {
        try {
            return protocolDao.queryForEq("healthClientID", userid);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public void testLoop (){
        while (true){
            List<Appointment> appointments = fetchAllAppointments();
            System.out.println(appointments);

            HealthClient hc = appointments.get(2).getHealthClient();
            System.out.println(hc);

            List<Protocol> protocols = fetchAllProtocols();
            System.out.println(protocols);

            HealthVisitor hv = protocols.get(3).getHealthVisitor();
            System.out.println(hv);

            Protocol protocol = new Protocol(hv, hc, LocalDateTime.now(), ProtocolType.NOTIZ, "Meine geile Notiz");
            ApplicationModelManager.getInstance().createProtocol(protocol);
        }
    }

    private void loadAppointmentsFromMockData() {
        for (Appointment appointment : AppointmentMock.getAppointments()) {
            try{
                appointmentDao.create(appointment);
            }catch (SQLException exception){
                ///TODO: EXCEPTION HANDLING
                System.out.println(exception.getMessage());
            }
        }
    }

    private void loadProtocolsFromMockData() {
        for (Protocol protocol : ProtocolMock.getProtocols()) {
            try{
                protocolDao.create(protocol);
            }catch (SQLException exception){
                System.out.println(exception.getMessage());
            }
        }
    }

    public Dao<Protocol, Integer> getProtocolDao() {
        return protocolDao;
    }
}
