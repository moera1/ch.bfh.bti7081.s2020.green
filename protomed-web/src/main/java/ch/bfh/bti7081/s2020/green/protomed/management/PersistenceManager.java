package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.management.mock.AppointmentMock;
import ch.bfh.bti7081.s2020.green.protomed.management.mock.ProtocolMock;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;
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

    public static PersistenceManager getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new PersistenceManager();
        }
        return instance;
    }

    private PersistenceManager() {
    }

    public void initialize(PersistenceStrategy persistenceStrategy){
        if (persistenceStrategy != null) this.persistenceStrategy = persistenceStrategy;
        if (persistenceStrategy == PersistenceStrategy.PERSISTENCE_STRATEGY_MOCK_DATA) {
            loadAppointmentsFromMockData();
            loadProtocolsFromMockData();
        }
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
        try (JdbcPooledConnectionSource connectionSource
                     = new JdbcPooledConnectionSource(connectionURL())){

            Dao<Appointment, Long> appointmentDao = DaoManager.createDao(connectionSource, Appointment.class);
            return appointmentDao.queryForAll();
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Appointment> fetchAppointmentsByVisitorID(Integer userid) {
        try (JdbcPooledConnectionSource connectionSource
                     = new JdbcPooledConnectionSource(connectionURL())){

            Dao<Appointment, Long> appointmentDao = DaoManager.createDao(connectionSource, Appointment.class);
            return appointmentDao.queryForEq("healthVisitorID", userid);
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Appointment> fetchAppointmentsByClientID(Integer userid) {
        try (JdbcPooledConnectionSource connectionSource
                     = new JdbcPooledConnectionSource(connectionURL())){

            Dao<Appointment, Long> appointmentDao = DaoManager.createDao(connectionSource, Appointment.class);
            return appointmentDao.queryForEq("healthClientID", userid);
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveAppointments(List<Appointment> appointments) {
        // TODO: Implement DB Query
    }

    public void saveAppointment(Appointment appointment) {
        // TODO: Implement DB Query
    }

    public List<Protocol> fetchAllProtocols() {
        try (JdbcPooledConnectionSource connectionSource
                     = new JdbcPooledConnectionSource(connectionURL())){

            Dao<Protocol, Long> protocolDao = DaoManager.createDao(connectionSource, Protocol.class);
            return protocolDao.queryForAll();
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Protocol> fetchAllProtocolsByVisitorID(Integer userid) {
        try (JdbcPooledConnectionSource connectionSource
                     = new JdbcPooledConnectionSource(connectionURL())){

            Dao<Protocol, Long> protocolDao = DaoManager.createDao(connectionSource, Protocol.class);
            return protocolDao.queryForEq("healthVisitorID", userid);
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Protocol> fetchAllProtocolsByClientID(Integer userid) {
        try (JdbcPooledConnectionSource connectionSource
                     = new JdbcPooledConnectionSource(connectionURL())){

            Dao<Protocol, Long> protocolDao = DaoManager.createDao(connectionSource, Protocol.class);
            return protocolDao.queryForEq("healthClientID", userid);
        } catch (IOException | SQLException exception) {
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
        }
    }

    private void loadAppointmentsFromMockData() {
        List<Appointment> appointments = AppointmentMock.getAppointments();

        try (JdbcPooledConnectionSource connectionSource
                     = new JdbcPooledConnectionSource(connectionURL())){

            TableUtils.createTableIfNotExists(connectionSource, Appointment.class);

            for (Appointment appointment : appointments) {
                try{
                    Dao<Appointment, Long> appointmentDao = DaoManager.createDao(connectionSource, Appointment.class);
                    appointmentDao.create(appointment);
                }catch (SQLException exception){
                    ///TODO: EXCEPTION HANDLING
                    System.out.println(exception.getMessage());
                }
            }
            Dao<Appointment, Long> appointmentDao = DaoManager.createDao(connectionSource, Appointment.class);
            appointmentDao.forEach(appointment -> {
                System.out.println(appointment.getId());
            });
        } catch (IOException | SQLException exception) {
            ///TODO: Exception Handling
            System.out.println(exception.getMessage());
        }
    }

    private void loadProtocolsFromMockData() {
        List<Protocol> protocols = ProtocolMock.getProtocols();

        try (JdbcPooledConnectionSource connectionSource
                     = new JdbcPooledConnectionSource(connectionURL())){

            TableUtils.createTable(connectionSource, Protocol.class);

            for (Protocol protocol : protocols) {
                try{
                    Dao<Protocol, Long> protocolDao = DaoManager.createDao(connectionSource, Protocol.class);
                    protocolDao.create(protocol);
                }catch (SQLException exception){
                    System.out.println(exception.getMessage());
                }
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
