package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolCreateView;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolCreateViewImplementation;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;

public class ProtocolCreateButton extends Div {

    private ProtocolCreateViewImplementation createView;

    private Button createProtocol = new Button("Protokoll erstellen");

    public ProtocolCreateButton() {
        add(createProtocol);
        createProtocol.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }

    public void loadCreateProtocolView(Protocol protocol) {
        createProtocol.addClickListener(event -> {
            for (ProtocolCreateView.ProtocolCreateViewListener listener : createView.getListeners()) {
                listener.createProtocol(protocol);
            }

        });
    }


}
