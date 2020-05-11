package ch.bfh.bti7081.s2020.green.protomed.component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppointmentOverview extends Div {

    private H3 title = new H3("Nächste Termine");
    private Button showAllButton = new Button("Alle anzeigen");

    public AppointmentOverview() {
        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();

        Div panelContent = new Div();
        panelContent.addClassName("panel-content");
        panelContent.setSizeFull();

        showAllButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        showAllButton.addClassName("panel-btn");

        Div notificationContainer = new Div();
        notificationContainer.addClassName("notification-container");
        notificationContainer.add(new CalendarListItem("11:00 - Alexandra Vonesch", "Bernstrasse 107, 3007 Bern", "05/24/2020"));
        notificationContainer.add(new CalendarListItem("14:30 - Alexandra Vonesch", "Bernstrasse 107, 3007 Bern", "05/30/2020"));

        panelContent.add(title, notificationContainer, showAllButton);
        layout.add(panelContent);

        borderBox.add(layout);
        borderBox.addClassName("panel");

        add(borderBox);
        addClassName("panel-box");

    }
}
