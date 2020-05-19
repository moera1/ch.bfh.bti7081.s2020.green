package ch.bfh.bti7081.s2020.green.protomed.model;


import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.time.LocalDate;

@DatabaseTable
public class HealthClient extends Person {

    private HealthVisitor healthVisitor;

    @ForeignCollectionField(eager=false)
    private ForeignCollection<Appointment> appointments;

    /// open scope no-argument constructor required for ORMLite
    public HealthClient(){
        //
    }

    public HealthClient(HealthVisitor healthVisitor, int personId, Address address, String name, String firstname, LocalDate birthDate, String phoneNumber, String profilePicture) {
        super(personId, address, name, firstname, birthDate, phoneNumber, profilePicture);
        this.healthVisitor = healthVisitor;
    }
}
