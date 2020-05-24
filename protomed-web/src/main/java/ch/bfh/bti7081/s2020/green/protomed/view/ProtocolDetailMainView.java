package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.presenter.ProtocolDetailPresenter;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "protocol/detail", layout = MainLayout.class)
@PageTitle("Detailansicht Protokoll")
public class ProtocolDetailMainView extends Div {

    public ProtocolDetailMainView() {

        ProtocolDetailViewImplementation view = new ProtocolDetailViewImplementation();
        new ProtocolDetailPresenter(loadProtocol(1), view);

        add(view);
        addClassName("app-content");

    }

    private Protocol loadProtocol(int id) {
        return ApplicationModelManager.getInstance().getProtocolByID(id);
    }

}
