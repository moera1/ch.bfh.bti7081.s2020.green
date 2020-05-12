package ch.bfh.bti7081.s2020.green.protomed.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.presenter.ClientProfilePresenter;

@Route(value = "client", layout = MainLayout.class)
@PageTitle("Klient")
public class ClientProfileMainView extends Div {
    public ClientProfileMainView() {
        ClientProfileViewImplementation view = new ClientProfileViewImplementation();

        new ClientProfilePresenter(view);

        add(view);
        addClassName("app-content");
    }
}
