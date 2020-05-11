package ch.bfh.bti7081.s2020.green.protomed.component;

import com.vaadin.flow.component.html.Div;

public class ListItem extends Div {

    public ListItem(String titleText, String descriptionText) {
        addClassName("list-item");
        Div title = new Div();
        title.setText(titleText);
        Div description = new Div();
        description.setText(descriptionText);

        add(title, description);
    }
}
