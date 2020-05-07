package ch.bfh.bti7081.s2020.green.protomed.model;

import java.util.Date;
import java.util.Objects;

public abstract class Person {
    private static int personCounter = 0;
    private final int personId;
    private Address address;
    private String lastName;
    private String firstName;
    private Date birthDate;

    public Person(String lastName, String firstName, int age){
        this.lastName = lastName;
        this.firstName = firstName;
        this.personId = personCounter;
        personCounter++;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getPersonId() {
        return personId;
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
}
