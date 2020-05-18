package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.Address;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class HealthClientManager {

    private final static String HEALTH_CLIENT_PROVIDER_URL = "http://localhost:8090/";
    private final static String HEALTH_CLIENT_PROVIDER_ENDPOINT = "api/healthclients";

    private Set<HealthClient> healthClients = new HashSet<>();
    private ObjectMapper mapper = new ObjectMapper();

    // Singleton
    private static HealthClientManager instance;

    public static HealthClientManager getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new HealthClientManager();
        }
        return instance;
    }

    private HealthClientManager() {
    }

    public void initializeHealthClients() {
        List<LinkedHashMap<String, Object>> rawClients = getHealthClientsFromProvider();
        createHealthClients(rawClients);
    }

    private List<LinkedHashMap<String, Object>> getHealthClientsFromProvider() {
        try {
            List<LinkedHashMap<String, Object>> healthVisitors = mapper.readValue(new URL(HEALTH_CLIENT_PROVIDER_URL + HEALTH_CLIENT_PROVIDER_ENDPOINT), List.class);
            return healthVisitors;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void createHealthClients(List<LinkedHashMap<String, Object>> rawClients) {

        for (LinkedHashMap<String, Object> currentHashMap : rawClients) {
            try {
                LinkedHashMap<String, String> addressMap = (LinkedHashMap<String, String>) currentHashMap.get("address");

                HealthVisitor healthVisitor = HealthVisitorManager.getInstance().getHealthVisitor((Integer) currentHashMap.get("healthVisitorID"));
                if (healthVisitor == null) throw new Exception("Every health client needs a visitor");

                Address address = new Address(addressMap.get("street"), Integer.parseInt(addressMap.get("zipcode")), addressMap.get("town"), addressMap.get("country"));
                HealthClient healthClient = new HealthClient(
                        healthVisitor,
                        (Integer) currentHashMap.get("clientID"),
                        address,
                        currentHashMap.get("name").toString(),
                        currentHashMap.get("firstname").toString(),
                        LocalDate.parse(currentHashMap.get("birthdate").toString())
                );

                healthVisitor.addClient(healthClient);
                healthClients.add(healthClient);

            } catch (Exception e) {
                String exceptionMessage = e.getMessage();
            }
        }
    }

    public HealthClient getHealthClient(int id) {
        for (HealthClient healthClient : getHealthClients()) {
            if (healthClient.getPersonId() == id) return healthClient;
        }
        return null;
    }

    public Set<HealthClient> getHealthClients() {
        return healthClients;
    }
}
