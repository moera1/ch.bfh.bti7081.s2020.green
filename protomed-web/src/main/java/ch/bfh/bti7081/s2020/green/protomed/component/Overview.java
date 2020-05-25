package ch.bfh.bti7081.s2020.green.protomed.component;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Overview extends Div {

    public Overview() {
        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();
        H3 title = new H3("Statistik");

        Chart overviewChart = new Chart(ChartType.COLUMN);
        Configuration config = overviewChart.getConfiguration();

        // TODO: Add dynamic data (if we have enough mock-data eventually)
        ListSeries userAppointments = new ListSeries("Deine");
        userAppointments.setData(3, 5, 2, 7, 4);
        config.addSeries(userAppointments);

        ListSeries avgAppointments = new ListSeries("Protomoed ∅");
        avgAppointments.setData(4, 6, 3, 4, 3);
        config.addSeries(avgAppointments);

        XAxis xaxis = new XAxis();
        xaxis.setCategories("Jan", "Feb", "Mrz", "Apr", "Mai");
        config.addxAxis(xaxis);

        YAxis yaxis = new YAxis();
        yaxis.setTitle("Anzahl Termine");
        config.addyAxis(yaxis);

        layout.add(title, overviewChart);
        borderBox.add(layout);
        borderBox.addClassName("panel");

        add(borderBox);
        addClassName("panel-box");

    }
}
