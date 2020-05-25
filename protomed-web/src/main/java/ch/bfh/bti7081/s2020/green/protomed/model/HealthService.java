package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.Getter;

public class HealthService {

    @Getter
    private String serviceID;
    @Getter
    private String description;

    public HealthService(String serviceID, String description) {
        this.serviceID = serviceID;
        this.description = description;
    }

    @Override
    public String toString() {
        return "HealthService{" +
                "serviceID='" + serviceID + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
