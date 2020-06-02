package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;

@Route(value = "protocols", layout = MainLayout.class)
@PageTitle("Protokolle")
public class ProtocolMainView extends Div implements HasUrlParameter<String> {


    public ProtocolMainView() {

    }


    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        ProtocolViewImplementation view;

        if (parameter == null) {
            view = new ProtocolViewImplementation();
            new ProtocolPresenter(view);
        } else {
            view = new ProtocolViewImplementation(HealthClientManager.getInstance().getHealthClient(Integer.parseInt(parameter)));
            ProtocolPresenter p = new ProtocolPresenter(view);
            p.filterByHealthClient(HealthClientManager.getInstance().getHealthClient(Integer.parseInt(parameter)));
        }
        this.removeAll();
        add(view);
        addClassName("app-content");
    }


}
