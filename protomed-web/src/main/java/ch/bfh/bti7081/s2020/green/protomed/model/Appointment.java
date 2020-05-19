package ch.bfh.bti7081.s2020.green.protomed.model;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;

import java.time.LocalDateTime;

@DatabaseTable(tableName = "appointment")
public class Appointment {

    @Getter
    @DatabaseField(generatedId = true)
    private Long id;
    @Getter
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, canBeNull = false)
    private HealthVisitor healthVisitor;
    @Getter
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, canBeNull = false)
    private HealthClient healthClient;
    @Getter
    //@DatabaseField(persisterClass = LocalDateTimePersister.class)
    private LocalDateTime time;

    /// open scope no-argument constructor required for ORMLite
    public Appointment(){
        //
    }

    public Appointment(HealthVisitor healthVisitor, HealthClient healthClient, LocalDateTime time) {
        this.healthVisitor = healthVisitor;
        this.healthClient = healthClient;
        this.time = time;
    }
}
