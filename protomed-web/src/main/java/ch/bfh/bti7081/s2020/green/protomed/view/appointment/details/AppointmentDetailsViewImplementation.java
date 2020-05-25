package ch.bfh.bti7081.s2020.green.protomed.view.appointment.details;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.view.appointment.AppointmentDetailsView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class AppointmentDetailsViewImplementation extends VerticalLayout implements AppointmentDetailsView {
    private List<AppointmentDetailsViewListener> listeners = new ArrayList<>();

    public AppointmentDetailsViewImplementation(List<Appointment> appointments) {

    }

    @Override
    public void addListener(AppointmentDetailsViewListener listener) {
        listeners.add(listener);
    }

}
