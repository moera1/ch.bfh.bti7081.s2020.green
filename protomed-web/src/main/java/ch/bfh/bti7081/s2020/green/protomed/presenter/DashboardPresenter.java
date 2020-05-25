package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import ch.bfh.bti7081.s2020.green.protomed.view.dashboard.DashboardView;

import java.util.List;

public class DashboardPresenter implements DashboardView.DashboardViewListener {
    private DashboardView view;
    private HealthVisitor currentUser;
    private List<Appointment> userAppointments;

    public DashboardPresenter(DashboardView view) {
        this.view = view;
        view.addListener(this);
        currentUser = HealthVisitorManager.getInstance().getCurrentUser();
        view.loadDashboard(currentUser);
        userAppointments = ApplicationModelManager.getInstance().getAppointmentsByHealthVisitorID(currentUser.getPersonId());
        view.loadUserAppointments(userAppointments);
    }

    @Override
    public void selectAppointment(Appointment appointment) {
        view.navigateToAppointment(appointment.getId());
    }
}
