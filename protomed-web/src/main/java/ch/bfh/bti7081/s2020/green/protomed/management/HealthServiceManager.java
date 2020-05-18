package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.HealthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.net.URL;
import java.util.*;

public class HealthServiceManager {

    private final static String HEALTH_SERVICE_PROVIDER_URL = "http://localhost:8090/";
    private final static String HEALTH_SERVICE_PROVIDER_ENDPOINT = "api/healthservices";

    @Getter
    private Set<HealthService> healthServices = new HashSet<>();
    private ObjectMapper mapper = new ObjectMapper();

    // Singleton
    private static HealthServiceManager instance;

    public static HealthServiceManager getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new HealthServiceManager();
        }
        return instance;
    }

    private HealthServiceManager() {
    }

    public void initializeHealthServices() {
        List<LinkedHashMap<String, Object>> rawServices = getHealthServicesFromProvider();
        createHealthServices(rawServices);
    }

    private List<LinkedHashMap<String, Object>> getHealthServicesFromProvider() {
        try {
            List<LinkedHashMap<String, Object>> healthServices = mapper.readValue(new URL(HEALTH_SERVICE_PROVIDER_URL + HEALTH_SERVICE_PROVIDER_ENDPOINT), List.class);
            return healthServices;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void createHealthServices(List<LinkedHashMap<String, Object>> rawServices) {

        for (LinkedHashMap<String, Object> currentHashMap : rawServices) {
            try {

                HealthService healthService = new HealthService(
                        currentHashMap.get("serviceID").toString(),
                        currentHashMap.get("description").toString()
                );

                healthServices.add(healthService);

            } catch (Exception e) {
                String exceptionMessage = e.getMessage();
            }
        }
    }

    public HealthService getHealthService(String id) {
        for (HealthService healthService : getHealthServices()) {
            if (healthService.getServiceID().equals(id)) return healthService;
        }
        return null;
    }

}
