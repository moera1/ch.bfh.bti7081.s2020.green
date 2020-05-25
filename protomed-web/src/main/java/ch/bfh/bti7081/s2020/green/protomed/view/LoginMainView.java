package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Login;
import ch.bfh.bti7081.s2020.green.protomed.presenter.LoginPresenter;
import ch.bfh.bti7081.s2020.green.protomed.view.dashboard.DashboardMainView;
import ch.bfh.bti7081.s2020.green.protomed.view.login.LoginViewImplementation;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
public class LoginMainView extends VerticalLayout implements BeforeEnterObserver {

    public LoginMainView() {
        Login model = new Login();
        LoginViewImplementation view = new LoginViewImplementation();
        new LoginPresenter(model, view);

        add(view);
        view.setSizeFull();
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        /*Object userID = VaadinService.getCurrentRequest().getWrappedSession().getAttribute("id");
        if (userID != null) {
            System.out.println(HealthVisitorManager.getInstance().getHealthVisitor(Integer.parseInt(userID.toString())));
            this.getUI().ifPresent(ui ->
                    ui.navigate(DashboardMainView.class));
        }*/
    }
}
