package ch.bfh.bti7081.s2020.green.protomed.view.logout;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.view.LoginMainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route(value = "logout")
public class LogoutMainView extends UI implements BeforeEnterObserver {

    public LogoutMainView() {
        HealthVisitorManager.getInstance().resetCurrentUser();
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        event.forwardTo(LoginMainView.class);
    }
}
