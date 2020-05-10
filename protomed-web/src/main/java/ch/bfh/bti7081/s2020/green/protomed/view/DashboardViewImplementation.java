package ch.bfh.bti7081.s2020.green.protomed.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class DashboardViewImplementation extends VerticalLayout implements DashboardView {

    private List<DashboardView.DashboardViewListener> listeners = new ArrayList<DashboardView.DashboardViewListener>();

    public DashboardViewImplementation() {

        addClassName("dashboard-container");
        setSizeFull();

    }

    @Override
    public void addListener(DashboardViewListener listener) {
        listeners.add(listener);
    }
}
