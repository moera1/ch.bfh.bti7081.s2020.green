package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;

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
        Map<Integer, HealthVisitor> supervisorMap = createHealthVisitors(rawVisitors);
        setSupervisors(supervisorMap);
    }

    // TODO
    private List getHealthVisitorsFromProvider(){
        return null;
    }

    // TODO
    private Map<Integer, HealthVisitor> createHealthVisitors(List rawVisitors){
        Map<Integer, HealthVisitor> supervisorMap = new HashMap<>();
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
    private void setSupervisors(Map<Integer ,HealthVisitor> supervisorMap){
        // foreach x -> x
            // HealthVisitor supervisor = getHealthVisitor(key);
            // value.setSuperVisor(supervisor);
    }

    public Set<HealthVisitor> getHealthVisitors() {
        return healthVisitors;
    }
}
