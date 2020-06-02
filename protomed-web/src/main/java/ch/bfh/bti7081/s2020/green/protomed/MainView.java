package ch.bfh.bti7081.s2020.green.protomed;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.management.KadexInitializer;
import ch.bfh.bti7081.s2020.green.protomed.model.Login;
import ch.bfh.bti7081.s2020.green.protomed.presenter.LoginPresenter;
import ch.bfh.bti7081.s2020.green.protomed.view.DashboardMainView;
import ch.bfh.bti7081.s2020.green.protomed.view.LoginViewImplementation;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
//@PWA(name = "Protomed v0.0.1", shortName = "Protomed")
@CssImport("./styles/global.css")
@CssImport("./styles/components.css")
@CssImport("./styles/layout.css")
public class MainView extends VerticalLayout implements BeforeEnterObserver {

    public MainView() {
        new KadexInitializer();
        Login model = new Login();
        LoginViewImplementation view = new LoginViewImplementation();

        new LoginPresenter(model, view);
        add(view);
        view.setSizeFull();

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        // Check for currentUser, redirect to dashboard if already present
        if (HealthVisitorManager.getInstance().getCurrentUser() != null) {
            event.forwardTo(DashboardMainView.class);
        }
    }
}
