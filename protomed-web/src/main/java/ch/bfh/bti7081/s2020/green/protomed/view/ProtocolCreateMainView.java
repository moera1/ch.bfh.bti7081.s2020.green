package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.model.ProtocolType;
import ch.bfh.bti7081.s2020.green.protomed.presenter.ProtocolCreatePresenter;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDateTime;

@Route(value = "protocol-create", layout = MainLayout.class)
@PageTitle("Protokoll erstellen")
public class ProtocolCreateMainView extends Div implements HasUrlParameter<String> {
    ProtocolCreateViewImplementation view;
    Protocol model;
    Appointment appointment;


    public ProtocolCreateMainView() {

    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        appointment = ApplicationModelManager.getInstance().getAppointmentbyAppointmentID(Integer.parseInt(s)).get();
        view = new ProtocolCreateViewImplementation();
        model = new Protocol(HealthVisitorManager.getInstance().getCurrentUser(),
                appointment.getHealthClient(),
                LocalDateTime.now(),
                ProtocolType.BESUCH);
        model.setAppointment(appointment);
        new ProtocolCreatePresenter(view, model);
        add(view);
        addClassName("app-content");
    }
}
