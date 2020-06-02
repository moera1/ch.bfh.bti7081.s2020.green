package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "appointment", layout = MainLayout.class)
@PageTitle("Termine")
public class AppointmentDetailsMainView extends Div implements HasUrlParameter<String> {
    AppointmentDetailsViewImplementation view;

    public AppointmentDetailsMainView() {

    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String parameter) {
        view = new AppointmentDetailsViewImplementation(ApplicationModelManager
                .getInstance()
                .getAppointmentbyAppointmentID(Integer.parseInt(parameter))
                .get());

        new AppointmentDetailViewPresenter(view);

        add(view);
        addClassName("app-content");

    }
}
