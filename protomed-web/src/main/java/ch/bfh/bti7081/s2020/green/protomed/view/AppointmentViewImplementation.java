package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.CalendarListItem;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.ClickableCard;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class AppointmentViewImplementation extends VerticalLayout implements AppointmentView {

    private List<AppointmentViewListener> listeners = new ArrayList<AppointmentViewListener>();

    public AppointmentViewImplementation() {

        add(new H2("Nächste Termine"));

        ClickableCard card1 = new ClickableCard(
                onClick -> {
                    Notification.show("Card is clicked");
                },
                new CalendarListItem("11:00 - Alexandra Vonesch", "Bernstrasse 107, 3007 Bern", "05/24/2020")
        );

        ClickableCard card2 = new ClickableCard(
                onClick -> {
                    Notification.show("Card is clicked");
                },
                new CalendarListItem("14:00 - John Abara", "Bielstrasse 42, 3011 Bern", "05/24/2020")
        );


        ClickableCard card3 = new ClickableCard(
                onClick -> {
                    Notification.show("Card is clicked");
                },
                new CalendarListItem("09:00 - Michael Müller", "Wankdorfstrasse 102, 3014 Bern", "06/24/2020")
        );

        card1.setWidth("100%");
        card2.setWidth("100%");
        card3.setWidth("100%");

        add(card1);
        add(card2);
        add(card3);
    }

    @Override
    public void addListener(AppointmentViewListener listener) {

    }
}
