package ch.bfh.bti7081.s2020.green.protomed.model;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;

import java.time.LocalDateTime;

@DatabaseTable(tableName = "appointment")
public class Appointment {

    @Getter
    @DatabaseField(generatedId = true) private Long id;

    @DatabaseField private Integer healthVisitorID;
    private HealthVisitor healthVisitor;

    @DatabaseField private Integer healthClientID;
    private HealthClient healthClient;

    @Getter
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private LocalDateTime time;

    /// open scope no-argument constructor required for ORMLite
    public Appointment(){
        //
    }

    public Appointment(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime time) {
        this.setHealthVisitor(healthVisitor);
        this.setHealthClient(healthClient);
        this.time = time;
    }

    public HealthVisitor getHealthVisitor() {
        if (healthVisitor == null) {
            healthVisitor = HealthVisitorManager.getInstance().getHealthVisitor(healthVisitorID);
        }
        return healthVisitor;
    }

    private void setHealthVisitor(HealthVisitor healthVisitor){
        this.healthVisitorID = healthVisitor.getPersonId();
        this.healthVisitor = healthVisitor;
    }

    public HealthClient getHealthClient(){
        if (healthClient == null){
            healthClient = HealthClientManager.getInstance().getHealthClient(healthClientID);
        }
        return healthClient;
    }

    private void setHealthClient(HealthClient healthClient){
        this.healthClientID = healthClient.getPersonId();
        this.healthClient = healthClient;
    }
}
