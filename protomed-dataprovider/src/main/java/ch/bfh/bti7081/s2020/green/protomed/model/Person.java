package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public abstract class Person {

    private final @NonNull
    String name;
    private final @NonNull
    String firstname;
    private final @NonNull
    Address address;
    private final @NonNull
    LocalDate birthdate;
    private final @NonNull
    String phonenumber;
    private final @NonNull
    String profilepicture;

}
