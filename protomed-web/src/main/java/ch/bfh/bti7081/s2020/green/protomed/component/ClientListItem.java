package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ClientListItem extends HorizontalLayout {
    public ClientListItem(HealthClient client) {

        setWidthFull();
        setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        Image photo = new Image(client.getProfilePicture(), client.getFullName() + "'s profile picture");
        photo.setHeight("80px");
        
        Div desc = new Div();

        Div fullName = new Div();
        fullName.setText(client.getFirstname() + " " + client.getName());
        fullName.getStyle().set("font-weight", "bold");
        fullName.setWidthFull();
        desc.add(fullName);

        Div address = new Div();
        address.setText(client.getAddress().toString());
        address.setWidthFull();
        desc.add(address);

        expand(desc);

        Icon icon = new Icon(VaadinIcon.ANGLE_RIGHT);
        setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, icon);


        add(photo, desc, icon);
    }
}
