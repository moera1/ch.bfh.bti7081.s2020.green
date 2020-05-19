package ch.bfh.bti7081.s2020.green.protomed.model;

import com.j256.ormlite.field.DatabaseField;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {

    @DatabaseField(id = true)
    private Integer personId;
    @Getter @Setter
    private Address address;
    @Getter
    private String name;
    @Getter
    private String firstname;
    @Getter @Setter
    private LocalDate birthDate;

    /// open scope no-argument constructor required for ORMLite
    public Person(){
        //
    }

    public Person(int personId, Address address, String name, String firstname, LocalDate birthDate) {
        this.personId = personId;
        this.address = address;
        this.name = name;
        this.firstname = firstname;
        this.birthDate = birthDate;
    }

    public int getPersonId() {
        return personId;
    }
    
    public String getFullName() {
    	return firstname + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getPersonId() == person.getPersonId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId());
    }
    
    
    @Override
    public String toString() {
    	return firstname + " " + name + ", " + birthDate.toString() + ", " + address.toString() + "(ID:" + Integer.toString(personId) + ")";
    }
}
