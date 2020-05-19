package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {

    private final Integer personId;
    @Getter @Setter
    private Address address;
    @Getter
    private String name;
    @Getter
    private String firstname;
    @Getter @Setter
    private LocalDate birthDate;
    @Getter @Setter
    private String phoneNumber;
    @Getter
    private String profilePicture;

    public Person(int personId, Address address, String name, String firstname, LocalDate birthDate, String phoneNumber, String profilePicture) {
        this.personId = personId;
        this.address = address;
        this.name = name;
        this.firstname = firstname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.profilePicture = profilePicture;
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
