package ch.bfh.bti7081.s2020.green.protomed.model;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@DatabaseTable(tableName = "notification")
public class Notification implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
    @DatabaseField(generatedId = true)
    private Long id;

    @Getter
    @DatabaseField
    private Integer healthClientID;
    private HealthClient healthClient;
    @Getter
    @DatabaseField(columnDefinition = "VARCHAR(800)")
    private String content;
    @Getter
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private LocalDateTime creationDate;

    public Notification() {
    }

    public Notification(HealthClient healthClient, String content) {
        setHealthClient(healthClient);
        this.content = content;
        this.creationDate = LocalDateTime.now();
    }

    public void setHealthClient(HealthClient healthClient) {
        this.healthClientID = healthClient.getPersonId();
        this.healthClient = healthClient;
    }

    public HealthClient getHealthClient() {
        if (healthClient == null) {
            healthClient = HealthClientManager.getInstance().getHealthClient(healthClientID);
        }
        return healthClient;
    }
}
