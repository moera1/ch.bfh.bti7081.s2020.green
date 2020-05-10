package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "clients", layout = MainLayout.class)
public class ClientMainView extends Div {

    public ClientMainView() {
        ClientViewImplementation view = new ClientViewImplementation();

        // new ClientPresenter(view);

        add(view);
        addClassName("app-content");
    }

}
