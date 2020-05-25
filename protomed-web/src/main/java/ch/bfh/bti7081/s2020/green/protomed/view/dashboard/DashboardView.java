package ch.bfh.bti7081.s2020.green.protomed.view.dashboard;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;

import java.util.List;


public interface DashboardView {

    interface DashboardViewListener {
        void selectAppointment(Appointment appointment);
    }

    void addListener(DashboardViewListener listener);

    void loadDashboard(HealthVisitor currentUser);

    void loadUserAppointments(List<Appointment> appointments);

    void navigateToAppointment(long id);

}
