package ch.bfh.bti7081.s2020.green.protomed.management;

public class KadexInitializer {

    public KadexInitializer() {
        initialize();
    }

    private void initialize() {

        try {

            // Init config file
            initalizeApplicationConfiguration();

            // Init data
            initializeHealthVisitors();
            initializeHealthClients();
            initializeHealthServices();

            initializeApplicationModels();

            // get the application models
            //initializeApplicationModels();

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

    private void initalizeApplicationConfiguration() {
        ConfigurationManager.getInstance().loadConfigurations();
    }

    private void initializeHealthVisitors() {
        HealthVisitorManager.getInstance().initializeHealthVisitors();
    }

    private void initializeHealthClients() {
        HealthClientManager.getInstance().initializeHealthClients();
    }

    private void initializeHealthServices() {
        HealthServiceManager.getInstance().initializeHealthServices();
    }

    private void initializeApplicationModels() {
        try {
            PersistenceManager.getInstance().configureInstance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
