package management;

import model.HealthVisitor;

import java.util.*;

public class HealthVisitorManager {

    Set<HealthVisitor> healthVisitors = new HashSet<>();

    // Singleton
    private static HealthVisitorManager instance;

    public static HealthVisitorManager getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new HealthVisitorManager();
        }
        return instance;
    }

    private HealthVisitorManager(){}

    // TODO
    public void initializeHealthVisitors(){
        // List or something
        List rawVisitors = getHealthVisitorsFromProvider();
        Map<Integer, HealthVisitor> supervisorMap = new HashMap<>();
        createHealthVisitors(rawVisitors, supervisorMap);
    }

    // TODO
    private List getHealthVisitorsFromProvider(){
        return null;
    }

    // TODO
    private void createHealthVisitors(List rawVisitors, Map<Integer, HealthVisitor> supervisorMap){
        // foreach x -> x
            // HealthVisitor visitor = new HealthVisitor(x);
            // Address address = new Address(x);
            // visitor setAddress(address);
            // healthVisitors.add(visitor);
            // if (supervisor.id()){
            //  supervisorMap.put(supervisor.id(), this);
            // }
    }

    // TODO
    private void setSupervisors(Map<Integer ,HealthVisitor> supervisorMap){
        // foreach x -> x
            // HealthVisitor supervisor = getHealthVisitor(key);
            // value.setSuperVisor(supervisor);
    }

    public Set<HealthVisitor> getHealthVisitors() {
        return healthVisitors;
    }
}
