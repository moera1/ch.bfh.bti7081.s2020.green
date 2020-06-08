package ch.bfh.bti7081.s2020.green.protomed.model;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

public class HealthService implements Serializable {
	private static final long serialVersionUID = 1L;
	@Getter
    private String serviceID;
    @Getter
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthService that = (HealthService) o;
        return Objects.equals(serviceID, that.serviceID) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceID, description);
    }

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
