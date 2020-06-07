package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.ProtocolCreateButton;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class AppointmentDetailsViewImplementation extends VerticalLayout implements AppointmentDetailsView {
    private List<AppointmentDetailsViewListener> listeners = new ArrayList<>();
    private ProtocolEditViewImplementation editView;
    private ProtocolCreateButton protocolCreateButton;
    private Appointment appointment;

    //TODO: Bind Protocolform with Appointment
    public AppointmentDetailsViewImplementation(Appointment appointment) {
        this.appointment = appointment;
        protocolCreateButton = new ProtocolCreateButton(this);
        add(new H2("Terminübersicht"));
        add(new H3(appointment.getTimeAsString()));
        add(protocolCreateButton);
    }

    @Override
    public void addListener(AppointmentDetailsViewListener listener) {
        listeners.add(listener);
    }

    public List<AppointmentDetailsView.AppointmentDetailsViewListener> getListeners(){
        return listeners;
    }

    @Override
    public void loadCreateProtocolView() {
        protocolCreateButton.loadCreateProtocolView(appointment);
    }

}
