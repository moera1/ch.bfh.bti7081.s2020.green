package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.presenter.ClientProfilePresenter;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "client", layout = MainLayout.class)
@PageTitle("Klient")
public class ClientProfileMainView extends Div implements HasUrlParameter<String> {
    ClientProfileViewImplementation view;

    public ClientProfileMainView() {

    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        view = new ClientProfileViewImplementation(HealthClientManager.getInstance().getHealthClient(Integer.parseInt(parameter)));

        new ClientProfilePresenter(view);

        add(view);
        addClassName("app-content");
    }
}
