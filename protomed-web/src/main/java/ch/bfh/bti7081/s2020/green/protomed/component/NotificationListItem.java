package ch.bfh.bti7081.s2020.green.protomed.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class NotificationListItem extends HorizontalLayout {

    public NotificationListItem(String titleText, String descriptionText) {
        addClassName("list-item");

        setWidthFull();
        setJustifyContentMode(JustifyContentMode.BETWEEN);

        Div content = new Div();
        content.setWidthFull();
        content.addClassName("list-content");

        Div title = new Div();
        title.setText(titleText);
        title.setWidthFull();

        Div description = new Div();
        description.setText(descriptionText);
        description.setWidthFull();

        content.add(title, description);

        Icon icon = new Icon(VaadinIcon.ANGLE_RIGHT);
        icon.addClassName("icon-grey");
        setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, icon);

        add(content, icon);

    }
}
