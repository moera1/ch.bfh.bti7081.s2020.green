package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.view.DashboardMainView;
import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class NotificationOverview extends Div {

    private H3 title = new H3("Neuigkeiten");

    public NotificationOverview() {
        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();

        Div panelContent = new Div();
        panelContent.addClassName("panel-content");
        panelContent.setSizeFull();

        Div notificationContainer = new Div();
        notificationContainer.addClassName("notification-container");

        notificationContainer.add(new ClickableCard(
                onClick -> UI.getCurrent().navigate(DashboardMainView.class),
                new NotificationListItem("Neues Besuchsprotokoll verfügbar", "26.03.2020 von Gertrud Michel")
                )
        );
        notificationContainer.add(new ClickableCard(
                onClick -> UI.getCurrent().navigate(DashboardMainView.class),
                new NotificationListItem("Neues Telefonprotokoll verfügbar", "14.02.2020 von Gertrud Michel")
                )
        );

        panelContent.add(title, notificationContainer);
        layout.add(panelContent);

        borderBox.add(layout);
        borderBox.addClassName("panel");

        add(borderBox);
        addClassName("panel-box");
    }
}
