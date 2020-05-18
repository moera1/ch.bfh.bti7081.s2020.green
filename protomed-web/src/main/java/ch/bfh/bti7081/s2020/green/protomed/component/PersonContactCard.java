package ch.bfh.bti7081.s2020.green.protomed.component;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import ch.bfh.bti7081.s2020.green.protomed.model.Person;

public class PersonContactCard extends HorizontalLayout {

	public PersonContactCard(Person person) {
		
		VerticalLayout info = new VerticalLayout();
		
		Div fullName = new Div();
		fullName.setText(person.getFullName());
		info.add(fullName);
		
		Div street = new Div();
		street.setText(person.getAddress().getStreet());
		info.add(street);
		
		Div city = new Div();
		city.setText(person.getAddress().getPostalCode() + " " + person.getAddress().getCity());
		info.add(city);
		
		Div phone = new Div();
		//TODO: Replace with phone number from person
		phone.setText("+41 79 876 45 32");
		info.add(phone);
		
		
		//TODO: Replace with phone number from person
		Anchor phoneIcon = new Anchor("tel:"+"+41 79 876 45 32", new Icon(VaadinIcon.PHONE));
		setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, phoneIcon);
		
		add(info, phoneIcon);
	}

}
