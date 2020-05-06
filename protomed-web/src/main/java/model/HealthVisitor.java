package model;

import java.util.Set;

public class HealthVisitor extends Person {

    private final String username;
    private HealthVisitor supervisor;
    private Set<HealthVisitor> subordinates;
    private Set<HealthClient> clients;

    public HealthVisitor(String lastName, String firstName, int age, String username) {
        super(lastName, firstName, age);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setSupervisor(HealthVisitor supervisor) {
        supervisor.subordinates.add(this);
        this.supervisor = supervisor;
    }

    public void addClient(HealthClient client) {
        clients.add(client);
    }

    public HealthVisitor getSupervisor() {
        return supervisor;
    }

    public Set<HealthVisitor> getSubordinates() {
        return subordinates;
    }

    public Set<HealthClient> getClients() {
        return clients;
    }
}
