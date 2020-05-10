package ch.bfh.bti7081.s2020.green.protomed.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class ProtocolViewImplementation extends VerticalLayout implements ProtocolView {

    private List<ProtocolViewListener> listeners = new ArrayList<ProtocolViewListener>();

    public ProtocolViewImplementation() {

        addClassName("protocol-container");
    }

    @Override
    public void addListener(ProtocolView listener) {

    }
}
