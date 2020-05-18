package ch.bfh.bti7081.s2020.green.protomed.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;

public class ClientListItem extends HorizontalLayout {
	public ClientListItem(HealthClient client) {
		
		setWidthFull();
		setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

		//TODO: Load Client profile picture
		Image photo = new Image();
		
		Div desc = new Div();
		
        Div fullName = new Div();
        fullName.setText(client.getFirstname() + " " + client.getName());
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
