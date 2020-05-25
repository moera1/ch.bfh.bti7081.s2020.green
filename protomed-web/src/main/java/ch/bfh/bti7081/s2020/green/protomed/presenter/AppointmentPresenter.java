package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import ch.bfh.bti7081.s2020.green.protomed.view.AppointmentView;

import java.util.ArrayList;
import java.util.List;

public class AppointmentPresenter implements AppointmentView.AppointmentViewListener {
    private AppointmentView view;
    private List<Appointment> appointments;
    private HealthVisitor currentUser;

    public AppointmentPresenter(AppointmentView view){
        this.view = view;
        view.addListener(this);
        currentUser = HealthVisitorManager.getInstance().getCurrentUser();
        appointments = ApplicationModelManager.getInstance().getAppointmentsByHealthVisitorID(currentUser.getPersonId());
        view.updateAppointmentList(appointments);
    }

    @Override
    public void selectAppointment(Appointment appointment) {
        view.navigateToAppointment(appointment.getId());
    }

    @Override
    public void setSearchValue(String value) {
        List<Appointment> filteredAppointment = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getHealthClient().toString().toLowerCase().contains(value.toLowerCase())){
                filteredAppointment.add(appointment);
            }
        }
        view.updateAppointmentList(filteredAppointment);
    }
}
