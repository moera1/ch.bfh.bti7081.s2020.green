package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "protocols", layout = MainLayout.class)
@PageTitle("Protokolle")
public class ProtocolMainView extends Div {

    public ProtocolMainView() {

        ProtocolViewImplementation view = new ProtocolViewImplementation();

        new ProtocolPresenter(view);

        add(view);
        addClassName("app-content");

    }

}
