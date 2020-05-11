package ch.bfh.bti7081.s2020.green.protomed.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class Profile extends Div {

    public Profile() {

        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();

        Image image = new Image("images/max.png", "Profilbild");
        H4 welcomeMsg = new H4("Willkommen zurück, Max!");

        layout.add(image, welcomeMsg);
        borderBox.add(layout);
        borderBox.addClassName("panel");

        add(borderBox);
        addClassName("panel-box");
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

    }

}
