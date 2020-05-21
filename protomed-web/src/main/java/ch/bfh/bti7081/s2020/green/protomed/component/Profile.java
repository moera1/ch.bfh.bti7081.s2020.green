package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class Profile extends Div {

    Image userImage;
    H3 welcomeMsg;

    public Profile() {

        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();
        layout.setHeightFull();
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        userImage = new Image();
        welcomeMsg = new H3();

        layout.add(userImage, welcomeMsg);
        borderBox.add(layout);
        borderBox.addClassName("panel");

        add(borderBox);
        addClassName("panel-box");
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

    }

    public void loadProfile(HealthVisitor currentUser) {
        // TODO: replace mock image with profile picture
        //userImage.setSrc(currentUser.getProfilePicture());
        userImage.setSrc("images/max.png");
        userImage.setAlt("Profilbild");
        welcomeMsg.setText("Willkommen zurück, " + currentUser.getFirstname() + "!");
    }

}
