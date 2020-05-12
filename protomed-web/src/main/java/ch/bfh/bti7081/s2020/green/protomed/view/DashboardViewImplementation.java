package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.AppointmentOverview;
import ch.bfh.bti7081.s2020.green.protomed.component.NotificationOverview;
import ch.bfh.bti7081.s2020.green.protomed.component.Overview;
import ch.bfh.bti7081.s2020.green.protomed.component.Profile;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.board.Row;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class DashboardViewImplementation extends Board implements DashboardView {

    private List<DashboardView.DashboardViewListener> listeners = new ArrayList<DashboardView.DashboardViewListener>();

    public DashboardViewImplementation() {

        Profile child1 = new Profile();
        Overview child2 = new Overview();
        NotificationOverview child3 = new NotificationOverview();
        AppointmentOverview child4 = new AppointmentOverview();

        Row row1 = addRow(child1, child2);
        row1.setComponentSpan(child1,1);
        row1.setComponentSpan(child2,3);
        Row row2 = addRow(child3, child4);
        row2.setComponentSpan(child3,2);
        row2.setComponentSpan(child4,2);

        addClassName("dashboard-container");
        setSizeFull();

    }

    @Override
    public void addListener(DashboardViewListener listener) {
        listeners.add(listener);
    }
}
