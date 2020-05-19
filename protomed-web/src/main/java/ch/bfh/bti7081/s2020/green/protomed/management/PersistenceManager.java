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

import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;
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

    public void initPersistenceManager(){
        /// initialize with mock up data
        loadAppointmentsFromMockData();
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

    private void loadAppointmentsFromMockData() {
        List<Appointment> appointments = AppointmentMock.getAppointments();

        try (JdbcPooledConnectionSource connectionSource
                     = new JdbcPooledConnectionSource("jdbc:h2:mem:myDb")){

            TableUtils.createTableIfNotExists(connectionSource, HealthVisitor.class);
            TableUtils.createTableIfNotExists(connectionSource, HealthClient.class);
            TableUtils.createTable(connectionSource, Appointment.class);

            int i = 0;
            for (Appointment appointment : appointments) {
                try{
                    Dao<Appointment, Long> appointmentDao = DaoManager.createDao(connectionSource, Appointment.class);
                    appointmentDao.create(appointment);
                    System.out.println("0 | " + i + ": HC:" + appointment.getHealthClient().getPersonId()
                                                    + " HV:" + appointment.getHealthVisitor().getPersonId()
                                                    + " id:" + appointment.getId());
                }catch (SQLException exception){
                    ///TODO: EXCEPTION HANDLING
                    System.out.println(exception.getMessage());
                    System.out.println("X | " + i + ": " + appointment.getHealthClient().getPersonId() + " " + appointment.getId());
                }
                i++;
            }

            DaoManager.createDao(connectionSource, Appointment.class).forEach(appointment -> {
               //System.out.println(appointment.getId());
            });
        } catch (IOException | SQLException exception) {
            ///TODO: Exception Handling
            System.out.println(exception.getMessage());
        }

    }

}
