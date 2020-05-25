package ch.bfh.bti7081.s2020.green.protomed.view.appointment.main;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.presenter.AppointmentPresenter;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "appointments", layout = MainLayout.class)
public class AppointmentMainView extends Div {

    public AppointmentMainView() {

        AppointmentViewImplementation view = new AppointmentViewImplementation();

        new AppointmentPresenter(view);

        add(view);
        addClassName("app-content");

    }

}
