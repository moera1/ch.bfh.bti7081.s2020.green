package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.Address;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthService;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class HealthClientManager {

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
            List<LinkedHashMap<String, Object>> healthVisitors = mapper.readValue(new URL(ConfigurationManager.getInstance().getConfiguration().getHealthClientProviderUrl() + ConfigurationManager.getInstance().getConfiguration().getHealthClientProviderEndpoint()), List.class);
            return healthVisitors;
        } catch (IOException e) {
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

                List<LinkedHashMap<String, String>> serviceMap = (List<LinkedHashMap<String, String>>) currentHashMap.get("insuredServices");
                List<HealthService> insuredServices = new ArrayList<>();
                for (LinkedHashMap<String, String> service : serviceMap) {
                    insuredServices.add(new HealthService(service.get("serviceID"), service.get("description")));
                }

                HealthClient healthClient = new HealthClient(
                        healthVisitor,
                        insuredServices,
                        (Integer) currentHashMap.get("clientID"),
                        address,
                        currentHashMap.get("name").toString(),
                        currentHashMap.get("firstname").toString(),
                        LocalDate.parse(currentHashMap.get("birthdate").toString()),
                        currentHashMap.get("phonenumber").toString(),
                        currentHashMap.get("profilepicture").toString()
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
