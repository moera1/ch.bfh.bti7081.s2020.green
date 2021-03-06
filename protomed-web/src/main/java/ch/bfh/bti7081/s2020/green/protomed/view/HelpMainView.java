package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.presenter.HelpPresenter;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "help", layout = MainLayout.class)
@PageTitle("Hilfe")
public class HelpMainView extends Div {

    public HelpMainView() {

        HelpViewImplementation view = new HelpViewImplementation();

        new HelpPresenter(view, view.generalSelected(), view.depressionSelected(), view.apprenticesSelected());

        add(view);
        addClassName("app-content");

    }

}
