package ch.bfh.bti7081.s2020.green.protomed.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class HelpViewImplementation extends VerticalLayout implements HelpView {

    private List<HelpViewListener> listeners = new ArrayList<HelpViewListener>();

    public HelpViewImplementation() {

        addClassName("help-container");
    }

    @Override
    public void addListener(HelpViewListener listener) {

    }
}
