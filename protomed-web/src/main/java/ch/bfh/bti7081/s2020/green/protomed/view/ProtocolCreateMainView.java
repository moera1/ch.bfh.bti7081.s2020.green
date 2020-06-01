package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.presenter.ProtocolCreatePresenter;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "protocol-create", layout = MainLayout.class)
@PageTitle("Protokoll erstellen")
public class ProtocolCreateMainView extends Div implements HasUrlParameter<String> {
    ProtocolCreateViewImplementation view;
    Protocol model;

    public ProtocolCreateMainView() {

    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String parameter) {
        model = ApplicationModelManager.getInstance().getProtocolByID(Integer.parseInt(parameter)).get();
        view = new ProtocolCreateViewImplementation();
        new ProtocolCreatePresenter(view, model);

        add(view);
        addClassName("app-content");
    }
}
