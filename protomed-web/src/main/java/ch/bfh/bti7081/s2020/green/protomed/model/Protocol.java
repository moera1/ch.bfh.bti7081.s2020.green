package ch.bfh.bti7081.s2020.green.protomed.model;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@DatabaseTable(tableName = "protocol")
public class Protocol {

    @Getter
    @DatabaseField(generatedId = true) private Long id;

    @DatabaseField private Integer healthVisitorID;
    private HealthVisitor healthVisitor;

    @DatabaseField private Integer healthClientID;
    private HealthClient healthClient;

    @Getter @Setter
    @DatabaseField
    private String content;

    @Getter
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private LocalDateTime creationDate;

    @Getter
    @DatabaseField(dataType = DataType.ENUM_INTEGER)
    private ProtocolType protocolType;

    /// open scope no-argument constructor required for ORMLite
    public Protocol(){
        //
    }

    public Protocol(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime creationDate, ProtocolType protocolType) {
        this.setHealthVisitor(healthVisitor);
        this.setHealthClient(healthClient);
        this.creationDate = creationDate;
        this.protocolType = protocolType;
    }

    public Protocol(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime creationDate, ProtocolType protocolType, String content) {
        this(healthVisitor, healthClient, creationDate, protocolType);
        this.content = content;
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
