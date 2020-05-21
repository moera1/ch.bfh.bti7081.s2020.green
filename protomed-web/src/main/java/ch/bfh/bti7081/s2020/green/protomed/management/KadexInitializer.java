package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;

import java.util.List;

public class KadexInitializer {

    public KadexInitializer() {
        initialize();
    }

    private void initialize() {

        try {

            // first get healthVisitors - they are needed to init the clients
            initializeHealthVisitors();

            // get the healthClients
            initializeHealthClients();

            HealthServiceManager.getInstance().initializeHealthServices();

            // get the application models
            initializeApplicationModels();

            /// test stuff
            //PersistenceManager.getInstance().testLoop();
            /*
            ApplicationModelManager man = ApplicationModelManager.getInstance();
            HealthVisitor hv = HealthVisitorManager.getInstance().getHealthVisitor(2);
            HealthClient hc = HealthClientManager.getInstance().getHealthClient(3);
            List<Appointment> appointments = man.getAppointments();
            appointments = man.getAppointmentsByHealthVisitorID(hv.getPersonId());
            appointments = man.getAppointmentsByHealthClientID(hc.getPersonId());
            List<Protocol> protocols = man.getProtocols();
            protocols = man.getProtocolsByHealthVisitorID(hv.getPersonId());
            protocols = man.getProtocolsByHealthClientID(hc.getPersonId());
            */

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    private void initializeHealthVisitors() {
        HealthVisitorManager.getInstance().initializeHealthVisitors();
    }

    private void initializeHealthClients() {
        HealthClientManager.getInstance().initializeHealthClients();
    }

    private void initializeApplicationModels() {
        PersistenceManager.getInstance().initialize(PersistenceManager.PersistenceStrategy.PERSISTENCE_STRATEGY_MOCK_DATA);
    }
}
