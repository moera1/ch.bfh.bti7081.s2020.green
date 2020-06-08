package ch.bfh.bti7081.s2020.green.protomed.model;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthServiceManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DatabaseTable(tableName = "protocol")
public class Protocol implements Serializable {
	
	private static final long serialVersionUID = 1L;

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
    @Setter
    @DatabaseField
    private String content;

    @Getter
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private LocalDateTime creationDate;

    @Setter
    @Getter
    @DatabaseField(dataType = DataType.ENUM_INTEGER)
    private ProtocolType protocolType;

    @Getter
    @Setter
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    protected Appointment appointment;

    @DatabaseField(dataType = DataType.SERIALIZABLE)
    protected String[] serviceIds;

    /// open scope no-argument constructor required for ORMLite
    public Protocol() {
        //
    }

    public Protocol(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime creationDate, ProtocolType protocolType) {
        this.setHealthVisitor(healthVisitor);
        this.setHealthClient(healthClient);
        this.creationDate = creationDate;
        this.protocolType = protocolType;

        Notification notification = new Notification(healthClient, "New Protocol added!");
        healthVisitor.addNotification(notification);
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

    public void setHealthClient(HealthClient healthClient) {
        this.healthClientID = healthClient.getPersonId();
        this.healthClient = healthClient;
    }

    public Set<HealthService> getServices() {
        Set<HealthService> healthServices = new HashSet<>();
        if (serviceIds == null) {
            return null;
        }
        for (String service : serviceIds) {
            healthServices.add(HealthServiceManager.getInstance().getHealthService(service));
        }
        return healthServices;
    }

    public void setServices(Set<HealthService> services) {
        String[] ids = new String[services.size()];
        List<HealthService> serviceList = new ArrayList<>(services);

        for (int i = 0; i < services.size(); i++) {
            ids[i] = serviceList.get(i).getServiceID();
        }

        serviceIds = new String[0];
        serviceIds = ids;
    }

    @Override
    public String toString() {
        return "Protocol{" +
                "id=" + id +
                ", healthVisitorID=" + healthVisitorID +
                ", healthVisitor=" + healthVisitor +
                ", healthClientID=" + healthClientID +
                ", healthClient=" + healthClient +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", protocolType=" + protocolType +
                '}';
    }
}
