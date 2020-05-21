package ch.bfh.bti7081.s2020.green.protomed.view;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class AppointmentViewImplementation extends VerticalLayout implements AppointmentView {

    private List<AppointmentViewListener> listeners = new ArrayList<>();

    public AppointmentViewImplementation() {

        add(new H2("Nächste Termine"));

        // TODO: Replace mock-data with actual appointments from currentUser

//        ClickableCard card1 = new ClickableCard(
//                onClick -> {
//                    Notification.show("Card is clicked");
//                },
//                new CalendarListItem()
//        );
//
//        ClickableCard card2 = new ClickableCard(
//                onClick -> {
//                    Notification.show("Card is clicked");
//                },
//                new CalendarListItem()
//        );
//
//
//        ClickableCard card3 = new ClickableCard(
//                onClick -> {
//                    Notification.show("Card is clicked");
//                },
//                new CalendarListItem()
//        );
//
//        card1.setWidth("100%");
//        card2.setWidth("100%");
//        card3.setWidth("100%");
//
//        add(card1);
//        add(card2);
//        add(card3);
    }

    @Override
    public void addListener(AppointmentViewListener listener) {

    }
}
