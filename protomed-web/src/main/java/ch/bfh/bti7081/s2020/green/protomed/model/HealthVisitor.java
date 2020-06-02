package ch.bfh.bti7081.s2020.green.protomed.model;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HealthVisitor extends Person {

    private String email;
    private HealthVisitor supervisor;
    private final Set<HealthVisitor> subordinates = new HashSet<>();
    private final Set<HealthClient> clients = new HashSet<>();

    @Getter
    private List<Notification> notifications;

    public HealthVisitor(int employeeID, Address address, String name, String firstname, LocalDate birthdate, String phoneNumber, String profilePicture, String email) {
        super(employeeID, address, name, firstname, birthdate, phoneNumber, profilePicture);
        this.email = email;
        this.notifications = new ArrayList<>();
    }

    public String getUsername() {
        return email;
    }

    public void setSupervisor(HealthVisitor supervisor) {
        supervisor.subordinates.add(this);
        this.supervisor = supervisor;
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
        updateHealthVisitors();
    }

    private void updateHealthVisitors() {
        HealthVisitorManager.getInstance().updateHealthVisitor(this);
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
