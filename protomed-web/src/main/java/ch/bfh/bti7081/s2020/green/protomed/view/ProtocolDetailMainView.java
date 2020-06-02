package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.presenter.ProtocolDetailPresenter;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "protocol", layout = MainLayout.class)
@PageTitle("Detailansicht Protokoll")
public class ProtocolDetailMainView extends Div implements HasUrlParameter<Integer> {

    public ProtocolDetailMainView() {
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, Integer s) {
        if (s != null) {
            ProtocolDetailViewImplementation view = new ProtocolDetailViewImplementation();
            new ProtocolDetailPresenter(s, view);

            add(view);
            addClassName("app-content");
        } else {
            // TODO: Show error
        }
    }
}
