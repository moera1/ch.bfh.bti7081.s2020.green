package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.presenter.DashboardPresenter;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "dashboard", layout = MainLayout.class)
@PageTitle("Home")
public class DashboardMainView extends Div {

    public DashboardMainView() {
        if (hasCurrentUser()) {
            DashboardViewImplementation view = new DashboardViewImplementation();
            new DashboardPresenter(view);
            add(view);
        }

        addClassName("app-content");
    }

    private boolean hasCurrentUser() {
        return HealthVisitorManager.getInstance().getCurrentUser() != null;
    }
}
