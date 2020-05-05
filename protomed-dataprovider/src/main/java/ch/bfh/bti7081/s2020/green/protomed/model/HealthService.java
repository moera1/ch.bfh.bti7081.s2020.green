package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class HealthService {

    private final @NonNull String serviceID;
    private final @NonNull String description;

}
