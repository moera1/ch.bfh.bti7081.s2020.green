package ch.bfh.bti7081.s2020.green.protomed;

import ch.bfh.bti7081.s2020.green.protomed.model.Login;
import ch.bfh.bti7081.s2020.green.protomed.presenter.LoginPresenter;
import ch.bfh.bti7081.s2020.green.protomed.view.LoginViewImplementation;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Protomed v0.0.1", shortName = "Protomed")
public class MainView extends VerticalLayout {

    public MainView() {
        Login model = new Login();
        LoginViewImplementation view = new LoginViewImplementation();

        new LoginPresenter(model, view);

        add(view);
    }
}
