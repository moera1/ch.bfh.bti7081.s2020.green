package ch.bfh.bti7081.s2020.green.protomed.management.mock;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationMock {

    public static List<Notification> getNotifications() {
        List<Notification> notifications = new ArrayList<>();

        HealthClient daniel = HealthClientManager.getInstance().getHealthClient(1);
        HealthClient thomas = HealthClientManager.getInstance().getHealthClient(2);
        HealthClient lars = HealthClientManager.getInstance().getHealthClient(3);

        notifications.add(new Notification(daniel, "Neues Besuchsprotokoll verfügbar 1."));
        notifications.add(new Notification(daniel, "Neues Besuchsprotokoll verfügbar 2."));
        notifications.add(new Notification(daniel, "Neues Besuchsprotokoll verfügbar 3."));

        notifications.add(new Notification(thomas, "Neues Besuchsprotokoll verfügbar 4."));
        notifications.add(new Notification(thomas, "Neues Besuchsprotokoll verfügbar 5."));
        notifications.add(new Notification(thomas, "Neues Besuchsprotokoll verfügbar 6."));

        notifications.add(new Notification(lars, "Neues Besuchsprotokoll verfügbar 7."));
        notifications.add(new Notification(lars, "Neues Besuchsprotokoll verfügbar 8."));
        notifications.add(new Notification(lars, "Neues Besuchsprotokoll verfügbar 9."));

        return notifications;
    }


}
