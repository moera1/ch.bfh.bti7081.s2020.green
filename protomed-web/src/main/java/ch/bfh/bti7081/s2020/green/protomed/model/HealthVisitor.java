package ch.bfh.bti7081.s2020.green.protomed.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@DatabaseTable
public class HealthVisitor extends Person {

    private String email;
    private HealthVisitor supervisor;
    private final Set<HealthVisitor> subordinates = new HashSet<>();
    private final Set<HealthClient> clients = new HashSet<>();

    @ForeignCollectionField(eager=false)
    private ForeignCollection<Appointment> appointments;

    /// open scope no-argument constructor required for ORMLite
    public HealthVisitor(){
        //
    }

    public HealthVisitor(int employeeID, Address address, String name, String firstname, LocalDate birthdate, String email) {
        super(employeeID, address, name, firstname, birthdate);
        this.email = email;
    }

    public String getUsername() {
        return email;
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
