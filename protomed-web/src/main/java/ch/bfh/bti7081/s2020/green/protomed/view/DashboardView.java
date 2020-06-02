package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import ch.bfh.bti7081.s2020.green.protomed.model.Notification;

import java.util.List;


public interface DashboardView {

    interface DashboardViewListener {
        void selectAppointment(Appointment appointment);

        void selectNotification(Notification notification);
    }

    void addListener(DashboardViewListener listener);

    void loadDashboard(HealthVisitor currentUser);

    void loadUserAppointments(List<Appointment> appointments);

    void loadUserNotifications(List<Notification> notifications);

    void navigateToAppointment(long id);

    void navigateToNotification(long id);

}
