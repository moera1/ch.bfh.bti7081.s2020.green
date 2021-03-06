package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.view.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;

public class ProtocolCreateButton extends Div {

    private AppointmentDetailsViewImplementation appointmentDetailsViewImplementation;
    private ProtocolViewImplementation protocolViewImplementation;

    private Button createProtocol = new Button("Protokoll erstellen");

    public ProtocolCreateButton(AppointmentDetailsViewImplementation appointmentDetailsViewImplementation){
        this.appointmentDetailsViewImplementation = appointmentDetailsViewImplementation;
        add(createProtocol);
        createProtocol.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }

    public ProtocolCreateButton(ProtocolViewImplementation protocolViewImplementation){
        this.protocolViewImplementation = protocolViewImplementation;
        add(createProtocol);
        createProtocol.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }

    public void loadCreateProtocolView(Appointment appointment){
        createProtocol.addClickListener(event -> {
            for (AppointmentDetailsView.AppointmentDetailsViewListener listener : appointmentDetailsViewImplementation.getListeners()){
                listener.navigateToProtocolCreateView(appointment);
            }
        });
    }

    public void loadCreateProtocolViewFromProtocol(){
        createProtocol.addClickListener(event -> {
            for (ProtocolView.ProtocolViewListener listener : protocolViewImplementation.getListeners()){
                listener.navigateToProtocolCreateView();
            }
        });
    }


}
