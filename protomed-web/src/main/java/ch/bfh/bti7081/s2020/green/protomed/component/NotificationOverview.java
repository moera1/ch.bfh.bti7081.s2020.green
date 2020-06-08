package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.Notification;
import ch.bfh.bti7081.s2020.green.protomed.view.DashboardView;
import ch.bfh.bti7081.s2020.green.protomed.view.DashboardViewImplementation;
import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NotificationOverview extends Div {

    private Div notificationContainer;
    private H3 title = new H3("Neuigkeiten");

    private DashboardViewImplementation view;

    public NotificationOverview(DashboardViewImplementation view) {
        this.view = view;
        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();

        Div panelContent = new Div();
        panelContent.addClassName("panel-content");
        panelContent.setSizeFull();

        notificationContainer = new Div();
        notificationContainer.addClassName("notification-container");

        /*notificationContainer.add(new ClickableCard(
                onClick -> UI.getCurrent().navigate(DashboardMainView.class),
                new NotificationListItem("Neues Besuchsprotokoll verfügbar", "26.03.2020 von Gertrud Michel")
                )
        );
        notificationContainer.add(new ClickableCard(
                onClick -> UI.getCurrent().navigate(DashboardMainView.class),
                new NotificationListItem("Neues Telefonprotokoll verfügbar", "14.02.2020 von Gertrud Michel")
                )
        );*/

        panelContent.add(title, notificationContainer);
        layout.add(panelContent);

        borderBox.add(layout);
        borderBox.addClassName("panel");

        add(borderBox);
        addClassName("panel-box");
    }

    public void loadNotifications(List<Notification> notifications) {
        notificationContainer.removeAll();
        List<Notification> nextNotifications = notifications
                .stream()
                .sorted(Comparator.comparing(Notification::getCreationDate))
                .limit(2)
                .collect(Collectors.toList());
        for (Notification notification : nextNotifications) {
            ClickableCard notificationCard = new ClickableCard(
                    onClick -> {
                        for (DashboardView.DashboardViewListener listener : view.getListeners()) {
                            listener.selectNotification(notification);
                        }
                    },
                    new NotificationListItem(notification)
            );
            notificationCard.setWidthFull();
            notificationContainer.add(notificationCard);
        }
    }
}
