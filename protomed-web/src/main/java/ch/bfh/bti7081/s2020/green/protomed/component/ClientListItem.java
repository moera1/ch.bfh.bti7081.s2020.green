package ch.bfh.bti7081.s2020.green.protomed.component;

import java.util.Date;

import com.vaadin.flow.component.html.Div;

import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;

public class ClientListItem extends Div {
	public ClientListItem(HealthClient client) {
        addClassName("list-item");
        
        Div fullName = new Div();
        fullName.setText(client.getFirstname() + " " + client.getName());
        fullName.setWidthFull();
        add(fullName);
        
        Div address = new Div();
        address.setText(client.getAddress().toString());
        address.setWidthFull();
        add(address);
		/*
        addClassName("list-item");

        Div dateBox = new Div();
        dateBox.addClassName("date-box");

        Div listContent = new Div();
        listContent.addClassName("list-content");

        Div title = new Div();
        title.setText(titleText);
        Div description = new Div();
        description.setText(address);

        Div dayText = new Div();
        dayText.setText(dayFormat.format(Date.parse(date)));
        dayText.addClassName("date-day");
        Div monthText = new Div();
        monthText.addClassName("date-month");
        monthText.setText(monthFormat.format(Date.parse(date)));

        dateBox.add(dayText, monthText);
        listContent.add(title, description);
        add(dateBox);
        add(listContent);*/
    }
}
