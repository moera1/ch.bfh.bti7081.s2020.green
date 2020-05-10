package ch.bfh.bti7081.s2020.green.protomed.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class AppointmentViewImplementation extends VerticalLayout implements AppointmentView {

    private List<AppointmentViewListener> listeners = new ArrayList<AppointmentViewListener>();

    public AppointmentViewImplementation() {

        addClassName("appointment-container");
    }

    @Override
    public void addListener(AppointmentViewListener listener) {

    }
}
