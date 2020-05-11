package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.Address;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

@Slf4j
public class HealthVisitorManager {

    Set<HealthVisitor> healthVisitors = new HashSet<>();

    ObjectMapper mapper = new ObjectMapper();

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

    // TODO
    public void initializeHealthVisitors() {
        // List or something
        List rawVisitors = getHealthVisitorsFromProvider();
        Map<Integer, HealthVisitor> supervisorMap = createHealthVisitors(rawVisitors);
        setSupervisors(supervisorMap);
    }

    // TODO
    private List<HealthVisitor> getHealthVisitorsFromProvider() {
        try {
            List<HealthVisitor> healthVisitors = mapper.readValue(new URL("http://localhost:8090/api/healthvisitors"), List.class);
            return healthVisitors;
        } catch(Exception e) {
            log.info("Exception {}", e.getStackTrace());
        }
        return new ArrayList<>();
    }

    // TODO
    private Map<Integer, HealthVisitor> createHealthVisitors(List<LinkedHashMap> rawVisitors) {
        Map<Integer, HealthVisitor> supervisorMap = new HashMap<>();

        Iterator<LinkedHashMap> i = rawVisitors.iterator();
        while(i.hasNext()) {
             LinkedHashMap<String, Object> currentHashMap = i.next();
             LinkedHashMap<String, String> addressMap = (LinkedHashMap) currentHashMap.get("address");
             Address address = new Address(addressMap.get("street"), Integer.parseInt(addressMap.get("zipcode")),  addressMap.get("town"), addressMap.get("country"));
             HealthVisitor healthVisitor = new HealthVisitor(
                     (Integer)currentHashMap.get("employeeID"),
                     address,
                     currentHashMap.get("name").toString(),
                     currentHashMap.get("firstname").toString(),
                     LocalDate.parse(currentHashMap.get("birthdate").toString()),
                     currentHashMap.get("email").toString()
             );
            healthVisitors.add(healthVisitor);
        }

        // foreach x -> x
        // HealthVisitor visitor = new HealthVisitor(x);
        // Address address = new Address(x);
        // visitor setAddress(address);
        // healthVisitors.add(visitor);
        // if (supervisor.id()){
        //  supervisorMap.put(supervisor.id(), this);
        // }
        return supervisorMap;
    }

    // TODO
    private void setSupervisors(Map<Integer, HealthVisitor> supervisorMap) {
        // foreach x -> x
        // HealthVisitor supervisor = getHealthVisitor(key);
        // value.setSuperVisor(supervisor);
    }

    public Set<HealthVisitor> getHealthVisitors() {

        return healthVisitors;
    }
}
