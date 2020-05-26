package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ProtocolListItem extends HorizontalLayout {

    public ProtocolListItem(Protocol protocol){
        addClassName("list-item");

        setWidthFull();
        setJustifyContentMode(JustifyContentMode.BETWEEN);

        Div dateBox = new Div();
        dateBox.addClassName("date-box");

        Div dayText = new Div();
        dayText.setText(String.valueOf(protocol.getCreationDate().getDayOfMonth()));
        dayText.addClassName("date-day");

        Div monthText = new Div();
        monthText.addClassName("date-month");
        monthText.setText(String.valueOf(protocol.getCreationDate().getMonth()));

        dateBox.add(dayText, monthText);

        Div content = new Div();
        content.setWidthFull();
        content.addClassName("list-content");

        Div protocolType = new Div();
        protocolType.setText(
                protocol.getProtocolType().name().substring(0,1).toUpperCase() +
                protocol.getProtocolType().name().substring(1).toLowerCase() +
                "-Protokoll");
        protocolType.getStyle().set("font-weight", "bold");
        protocolType.setWidthFull();

        Div protocolClient = new Div();
        protocolClient.setText(protocol.getHealthClient().getFullName());

        content.add(protocolType, protocolClient);

        Icon icon = new Icon(VaadinIcon.ANGLE_RIGHT);
        icon.addClassName("icon-grey");
        setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, icon);

        add(dateBox, content, icon);
    }

}
