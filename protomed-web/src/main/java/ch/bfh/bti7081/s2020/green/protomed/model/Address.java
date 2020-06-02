package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.Getter;

public class Address {
    @Getter
    private String street;
    @Getter
    private int postalCode;
    @Getter
    private String city;
    @Getter
    private String country;

    public Address(String street, int zipcode, String city, String country) {
        this.street = street;
        this.postalCode = zipcode;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return street + ", " + Integer.toString(postalCode) + " " + city;
    }
}
