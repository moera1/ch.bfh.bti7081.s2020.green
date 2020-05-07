package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HealthClientManager {

    // Singleton
    private Set<HealthClient> healthClients = new HashSet<>();

    private static HealthClientManager instance;

    public static HealthClientManager getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new HealthClientManager();
        }
        return instance;
    }

    private HealthClientManager(){}

    // TODO
    public void initializeHealthClients(){
        // List or something
        List rawClients = getHealthClientsFromProvider();
        createHealthClients(rawClients);
    }

    // TODO
    private List getHealthClientsFromProvider(){
        return null;
    }

    // TODO
    private void createHealthClients(List rawClients){
        HealthVisitorManager hvManager = HealthVisitorManager.getInstance();
        Set<HealthVisitor> healthVisitors = hvManager.getHealthVisitors();
        // foreach x -> x
            // HealthClient client = new HealthClient(x);
            // Address address = new Address(x);
            // client setAddress(address);
            // healthClients.add(client);
            // healthVisitor.addClient(client);
    }

    public Set<HealthClient> getHealthClients() {
        return healthClients;
    }
}
