package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.layout.MainLayout;
import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.presenter.ProtocolEditPresenter;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;

@Route(value = "protocols-edit", layout = MainLayout.class)
@PageTitle("Protokoll bearbeiten")
public class ProtocolEditMainView extends Div implements HasUrlParameter<String> {
	ProtocolEditViewImplementation view;
	Protocol model;

    public ProtocolEditMainView() {

    }
    
    @Override
	public void setParameter(BeforeEvent event, String parameter) {
        model = ApplicationModelManager.getInstance().getProtocolByID(Integer.parseInt(parameter)).get();
        view = new ProtocolEditViewImplementation();
        new ProtocolEditPresenter(view, model);

        add(view);
        addClassName("app-content");
	}
}
