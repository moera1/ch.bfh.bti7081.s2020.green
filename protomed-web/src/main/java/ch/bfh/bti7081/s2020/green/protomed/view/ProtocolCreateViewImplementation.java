package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.ProtocolCreateForm;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class ProtocolCreateViewImplementation extends VerticalLayout implements ProtocolCreateView {

    private List<ProtocolCreateViewListener> listeners = new ArrayList<>();
    private ProtocolCreateForm protocolCreateForm;

    public ProtocolCreateViewImplementation() {
        add(new H2("Protokoll erstellen"));

        protocolCreateForm = new ProtocolCreateForm(this);

        add(protocolCreateForm);
        addClassName("protocol-container");
    }

    public List<ProtocolCreateViewListener> getListeners() {
        return listeners;
    }

    @Override
    public void addListener(ProtocolCreateViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void loadProtocolData(Protocol protocol) {
        protocolCreateForm.loadProtocolData(protocol);
    }

    public void navigateToCreateProtocol(Long id) {
        Long nextId = id++;
        UI.getCurrent().navigate("protocol-create/" + nextId);
    }
}
