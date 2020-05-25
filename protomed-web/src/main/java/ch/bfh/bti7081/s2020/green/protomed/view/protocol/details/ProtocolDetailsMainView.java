package ch.bfh.bti7081.s2020.green.protomed.view.protocol.details;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.presenter.ProtocolDetailPresenter;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "protocol/detail", layout = MainLayout.class)
@PageTitle("Detailansicht Protokoll")
public class ProtocolDetailsMainView extends Div implements HasUrlParameter<Integer> {

    public ProtocolDetailsMainView() {
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, Integer s) {
        if (s != null) {
            ProtocolDetailsViewImplementation view = new ProtocolDetailsViewImplementation();
            new ProtocolDetailPresenter(s, view);

            add(view);
            addClassName("app-content");
        } else {
            // TODO: Show error
        }
    }
}
