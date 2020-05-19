package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;

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

            HealthServiceManager.getInstance();

            // create the ApplicationManager and init it
            ApplicationModelManager.getInstance().initializeModels();

            /// test stuff
            //PersistenceManager.getInstance().initPersistenceManager();

//            HealthVisitor self = HealthVisitorManager.getInstance().getCurrentUser();
//            HealthVisitorManager.getInstance().logInUser("max.kummer@bfh-test.ch", "1234");
//
//            self = HealthVisitorManager.getInstance().getCurrentUser();
//
//            // wrong password throws exception
//            HealthVisitorManager.getInstance().logInUser("max.kummer@bfh-test.ch", "3456");

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
}
