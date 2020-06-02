package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.Address;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class HealthVisitorManager {

    private HealthVisitor currentUser;
    private Set<HealthVisitor> healthVisitors = new HashSet<>();
    private ObjectMapper mapper = new ObjectMapper();

    // Singleton
    private static HealthVisitorManager instance;

    public static HealthVisitorManager getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new HealthVisitorManager();
        }
        return instance;
    }

    private HealthVisitorManager() {
    }

    public void initializeHealthVisitors() {
        List<LinkedHashMap<String, Object>> rawVisitors = getHealthVisitorsFromProvider();
        createHealthVisitors(rawVisitors);
    }

    private List<LinkedHashMap<String, Object>> getHealthVisitorsFromProvider() {
        try {
            List<LinkedHashMap<String, Object>> healthVisitors = mapper.readValue(new URL(ConfigurationManager.getInstance().getConfiguration().getHealthVisitorProviderUrl() + ConfigurationManager.getInstance().getConfiguration().getHealthVisitorProviderEndpoint()), List.class);
            return healthVisitors;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void createHealthVisitors(List<LinkedHashMap<String, Object>> rawVisitors) {
        Map<Integer, HealthVisitor> supervisorMap = new HashMap<>();

        for (LinkedHashMap<String, Object> currentHashMap : rawVisitors) {
            LinkedHashMap<String, String> addressMap = (LinkedHashMap<String, String>) currentHashMap.get("address");
            Address address = new Address(addressMap.get("street"), Integer.parseInt(addressMap.get("zipcode")), addressMap.get("town"), addressMap.get("country"));
            HealthVisitor healthVisitor = new HealthVisitor(
                    (Integer) currentHashMap.get("employeeID"),
                    address,
                    currentHashMap.get("name").toString(),
                    currentHashMap.get("firstname").toString(),
                    LocalDate.parse(currentHashMap.get("birthdate").toString()),
                    currentHashMap.get("phonenumber").toString(),
                    currentHashMap.get("profilepicture").toString(),
                    currentHashMap.get("email").toString()
            );

            if (currentHashMap.get("supervisorID") != null) {
                supervisorMap.put((Integer) currentHashMap.get("supervisorID"), healthVisitor);
            }
            healthVisitors.add(healthVisitor);
        }
        setSupervisors(supervisorMap);
    }

    private void setSupervisors(Map<Integer, HealthVisitor> supervisorMap) {

        for (Integer supervisorID : supervisorMap.keySet()) {
            HealthVisitor supervisor = getHealthVisitor(supervisorID);
            HealthVisitor subordinate = supervisorMap.getOrDefault(supervisorID, null);
            subordinate.setSupervisor(supervisor);
        }
    }

    public HealthVisitor getCurrentUser() {
        return currentUser;
    }

    private void setCurrentUser(HealthVisitor currentUser) {
        this.currentUser = currentUser;
    }

    public void resetCurrentUser() {
        currentUser = null;
    }

    public void logInUser(final String email, final String password) throws Exception {

        resetCurrentUser();

        try {
            String urlString = ConfigurationManager.getInstance().getConfiguration().getHealthVisitorProviderUrl() + ConfigurationManager.getInstance().getConfiguration().getHealthVisitorAuthEndpoint();
            String urlStringWithParams = urlString + "?email=" + email + "&password=" + password;
            URL url = new URL(urlStringWithParams);
            LinkedHashMap<String, Object> healthVisitorMap = mapper.readValue(url, LinkedHashMap.class);

            Integer userId = (Integer) healthVisitorMap.get("employeeID");
            HealthVisitor currentUser = getHealthVisitor(userId);
            if (currentUser == null) throw new Exception("No local user with userId:" + userId + "found");

            setCurrentUser(currentUser);

        } catch (IOException e) {
            throw e;
        }
    }

    public HealthVisitor getHealthVisitor(int id) {
        for (HealthVisitor healthVisitor : getHealthVisitors()) {
            if (healthVisitor.getPersonId() == id) return healthVisitor;
        }
        return null;
    }

    public Set<HealthVisitor> getHealthVisitors() {
        return healthVisitors;
    }

    public void updateHealthVisitor(HealthVisitor healthVisitor) {
        this.healthVisitors.remove(healthVisitor);
        this.healthVisitors.add(healthVisitor);
        if (currentUser != null && healthVisitor.getUsername().equals(currentUser.getUsername())) {
            this.currentUser = healthVisitor;
        }
    }
}
