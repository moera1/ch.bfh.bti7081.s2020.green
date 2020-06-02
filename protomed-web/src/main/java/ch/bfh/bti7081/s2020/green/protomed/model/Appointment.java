package ch.bfh.bti7081.s2020.green.protomed.model;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@DatabaseTable(tableName = "appointment")
public class Appointment {

    @Getter
    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private Integer healthVisitorID;
    private HealthVisitor healthVisitor;

    @DatabaseField
    private Integer healthClientID;
    private HealthClient healthClient;

    @Getter
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private LocalDateTime time;

    /// open scope no-argument constructor required for ORMLite
    public Appointment() {
        //
    }

    public Appointment(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime time) {
        this.setHealthVisitor(healthVisitor);
        this.setHealthClient(healthClient);
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", healthVisitorID=" + healthVisitorID +
                ", healthVisitor=" + getHealthVisitor().getFullName() +
                ", healthClientID=" + getHealthClient().getFullName() +
                ", healthClient=" + healthClient +
                ", time=" + time +
                '}';
    }

    public HealthVisitor getHealthVisitor() {
        if (healthVisitor == null) {
            healthVisitor = HealthVisitorManager.getInstance().getHealthVisitor(healthVisitorID);
        }
        return healthVisitor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(healthVisitorID, that.healthVisitorID) &&
                Objects.equals(healthClientID, that.healthClientID) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, healthVisitorID, healthVisitor, healthClientID, healthClient, time);
    }

    private void setHealthVisitor(HealthVisitor healthVisitor) {
        this.healthVisitorID = healthVisitor.getPersonId();
        this.healthVisitor = healthVisitor;
    }

    public HealthClient getHealthClient() {
        if (healthClient == null) {
            healthClient = HealthClientManager.getInstance().getHealthClient(healthClientID);
        }
        return healthClient;
    }

    private void setHealthClient(HealthClient healthClient) {
        this.healthClientID = healthClient.getPersonId();
        this.healthClient = healthClient;
    }

    public String getTimeAsString() {
        return "Besuch vom " + this.time.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) + " (" + this.getHealthVisitor().getFullName() + ")";
    }
}
