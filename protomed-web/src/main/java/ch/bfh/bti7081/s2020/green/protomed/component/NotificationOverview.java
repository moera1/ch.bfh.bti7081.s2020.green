package ch.bfh.bti7081.s2020.green.protomed.component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class NotificationOverview extends Div {

    private H3 title = new H3("Neuigkeiten");
    private Button showAllButton = new Button("Alle anzeigen");

    public NotificationOverview() {
        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();

        Div panelContent = new Div();
        panelContent.addClassName("panel-content");
        panelContent.setSizeFull();

        showAllButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        showAllButton.addClassName("panel-btn");

        Div notificationContainer = new Div();
        notificationContainer.addClassName("notification-container");
        notificationContainer.add(new ListItem("Neues Besuchsprotokoll verfügbar", "26.03.2020 von Gertrud Michel"));
        notificationContainer.add(new ListItem("Neues Telefonprotokoll verfügbar", "14.02.2020 von Gertrud Michel"));

        panelContent.add(title, notificationContainer, showAllButton);
        layout.add(panelContent);

        borderBox.add(layout);
        borderBox.addClassName("panel");

        add(borderBox);
        addClassName("panel-box");
    }
}
