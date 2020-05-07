package ch.bfh.bti7081.s2020.green.protomed.model;

public class Address {
    private String street;
    private int number;
    private int postalCode;
    private String city;

    public Address(String street, int number, int postalCode, String city){
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
