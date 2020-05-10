package ch.bfh.bti7081.s2020.green.protomed.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class ClientViewImplementation extends VerticalLayout implements ClientView {

    private List<ClientViewListener> listeners = new ArrayList<ClientViewListener>();

    public ClientViewImplementation() {

        addClassName("client-container");
    }

    @Override
    public void addListener(ClientViewListener listener) {

    }
}
