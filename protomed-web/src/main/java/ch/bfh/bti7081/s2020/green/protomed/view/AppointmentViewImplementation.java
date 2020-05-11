package ch.bfh.bti7081.s2020.green.protomed.view;

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
                new Label("12. Mai"),
                new Icon(VaadinIcon.VAADIN_H),
                new Label("11:00 - Alexandra Vonesch"),
                new Label("Bernstrasse 107, 3007 Bern")
        );

        ClickableCard card2 = new ClickableCard(
                onClick -> {
                    Notification.show("Card is clicked");
                },
                new Label("12. Mai"),
                new Icon(VaadinIcon.VAADIN_H),
                new Label("14:00 - John Abara"),
                new Label("Bielstrasse 42, 3011 Bern")
        );


        ClickableCard card3 = new ClickableCard(
                onClick -> {
                    Notification.show("Card is clicked");
                },
                new Label("12. Mai"),
                new Icon(VaadinIcon.VAADIN_H),
                new Label("09:00 - Michael Müller"),
                new Label("Wankdorfstrasse 102, 3014 Bern")
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
