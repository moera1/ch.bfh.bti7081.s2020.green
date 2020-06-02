package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.ProtocolCreateButton;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class AppointmentDetailsViewImplementation extends VerticalLayout implements AppointmentDetailsView {
    private List<AppointmentDetailsViewListener> listeners = new ArrayList<>();
    private ProtocolEditViewImplementation editView;

    //TODO: Bind Protocolform with Appointment
    public AppointmentDetailsViewImplementation(Appointment appointment) {
        add(new H2("Terminübersicht"));
        add(new H3(appointment.getTimeAsString()));
        add(new ProtocolCreateButton());
    }

    @Override
    public void addListener(AppointmentDetailsViewListener listener) {
        listeners.add(listener);
    }

}
