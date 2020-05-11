package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Address {

    private final @NonNull
    String street;
    private final @NonNull
    String town;
    private final @NonNull
    String zipcode;
    private final @NonNull
    String country;

}
