package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;

import java.util.List;

public interface AppointmentView {

    interface AppointmentViewListener {

        void selectAppointment(Appointment appointment);
        void setSearchValue(String value);
    }

    public void updateAppointmentList(List<Appointment> clients);

    public void navigateToAppointment(Long id);

    public void addListener(AppointmentViewListener listener);
}
