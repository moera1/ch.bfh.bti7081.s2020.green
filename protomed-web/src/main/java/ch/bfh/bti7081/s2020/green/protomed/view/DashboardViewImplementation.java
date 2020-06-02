package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.AppointmentOverview;
import ch.bfh.bti7081.s2020.green.protomed.component.NotificationOverview;
import ch.bfh.bti7081.s2020.green.protomed.component.Overview;
import ch.bfh.bti7081.s2020.green.protomed.component.Profile;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import ch.bfh.bti7081.s2020.green.protomed.model.Notification;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.board.Row;

import java.util.ArrayList;
import java.util.List;

public class DashboardViewImplementation extends Board implements DashboardView {

    private List<DashboardView.DashboardViewListener> listeners = new ArrayList<>();
    private Profile userProfile;
    private AppointmentOverview appointmentOverview;
    private NotificationOverview notificationOverview;


    public DashboardViewImplementation() {

        userProfile = new Profile();
        Overview overview = new Overview();
        notificationOverview = new NotificationOverview(this);
        appointmentOverview = new AppointmentOverview(this);

        Row row1 = addRow(userProfile, overview);
        row1.setComponentSpan(userProfile, 1);
        row1.setComponentSpan(overview, 3);
        Row row2 = addRow(notificationOverview, appointmentOverview);
        row2.setComponentSpan(notificationOverview, 2);
        row2.setComponentSpan(appointmentOverview, 2);

        addClassName("dashboard-container");
        setSizeFull();

    }

    public List<DashboardViewListener> getListeners() {
        return listeners;
    }

    @Override
    public void addListener(DashboardViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void loadDashboard(HealthVisitor currentUser) {
        userProfile.loadProfile(currentUser);
    }

    @Override
    public void loadUserAppointments(List<Appointment> appointments) {
        appointmentOverview.loadNextAppointments(appointments);
    }

    @Override
    public void loadUserNotifications(List<Notification> notifications) {
        notificationOverview.loadNotifications(notifications);
    }

    @Override
    public void navigateToAppointment(long id) {
        UI.getCurrent().navigate("appointment/" + id);
    }

    @Override
    public void navigateToNotification(long id) {
        UI.getCurrent().navigate("notifications/" + id);
    }
}
