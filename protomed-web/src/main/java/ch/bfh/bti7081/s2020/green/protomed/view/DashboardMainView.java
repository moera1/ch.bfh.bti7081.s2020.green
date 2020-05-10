package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.presenter.DashboardPresenter;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "dashboard", layout = MainLayout.class)
public class DashboardMainView extends Div {

    public DashboardMainView() {
        DashboardViewImplementation view = new DashboardViewImplementation();

        new DashboardPresenter(view);

        add(view);
        addClassName("app-content");
    }


}
