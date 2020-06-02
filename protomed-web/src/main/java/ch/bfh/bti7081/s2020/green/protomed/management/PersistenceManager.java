package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.management.mock.AppointmentMock;
import ch.bfh.bti7081.s2020.green.protomed.management.mock.FAQMock;
import ch.bfh.bti7081.s2020.green.protomed.management.mock.NotificationMock;
import ch.bfh.bti7081.s2020.green.protomed.management.mock.ProtocolMock;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.FAQEntry;
import ch.bfh.bti7081.s2020.green.protomed.model.Notification;
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

    private PersistenceStrategy persistenceStrategy;

    private JdbcConnectionSource connectionSource;
    private Dao<Appointment, Integer> appointmentDao;
    private Dao<Protocol, Integer> protocolDao;
    private Dao<FAQEntry, Integer> faqEntryDao;
    private Dao<Notification, Integer> notificationDao;

    public static PersistenceManager getInstance() {
        if (instance == null) {
            instance = new PersistenceManager();
        }
        return instance;
    }

    private PersistenceManager() {
    }

    public void configureInstance() throws Exception {
        loadPersistenceStrategy();
        initializeAndConnectDB();
        appointmentDao = DaoManager.createDao(connectionSource, Appointment.class);
        protocolDao = DaoManager.createDao(connectionSource, Protocol.class);
        faqEntryDao = DaoManager.createDao(connectionSource, FAQEntry.class);
        notificationDao = DaoManager.createDao(connectionSource, Notification.class);

        if (persistenceStrategy == PersistenceStrategy.PERSISTENCE_STRATEGY_MOCK_DATA) {
            loadAppointmentsFromMockData();
            loadProtocolsFromMockData();
            loadFAQEntriesFromMockData();
            loadNotificationsFromMockData();
        }
    }

    private void initializeAndConnectDB() throws SQLException {
        this.connectionSource = new JdbcConnectionSource(connectionURL());
        TableUtils.createTableIfNotExists(connectionSource, Appointment.class);
        TableUtils.createTableIfNotExists(connectionSource, Protocol.class);
        TableUtils.createTableIfNotExists(connectionSource, FAQEntry.class);
        TableUtils.createTableIfNotExists(connectionSource, Notification.class);
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
            return ConfigurationManager.getInstance().getConfiguration().getkSqliteUrl();
        else if (persistenceStrategy == PersistenceStrategy.PERSISTENCE_STRATEGY_MOCK_DATA)
            return ConfigurationManager.getInstance().getConfiguration().getkMemoryUrl();
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

    private void loadFAQEntriesFromMockData() {
        for (FAQEntry faqEntry : FAQMock.getFAQEntries()) {
            try {
                faqEntryDao.create(faqEntry);
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void loadNotificationsFromMockData() {
        for (Notification notification : NotificationMock.getNotifications()) {
            try {
                notificationDao.create(notification);
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

    public Dao<FAQEntry, Integer> getFAQEntryDao() {
        return faqEntryDao;
    }

    public Dao<Notification, Integer> getNotificationsDao() {
        return notificationDao;
    }

    private void loadPersistenceStrategy() {
        persistenceStrategy = ConfigurationManager.getInstance().getConfiguration().getStrategy();
    }

}
