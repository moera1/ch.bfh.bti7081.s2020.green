package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentListItem extends HorizontalLayout {

    public AppointmentListItem(Appointment appointment) {
        addClassName("list-item");

        setWidthFull();
        setJustifyContentMode(JustifyContentMode.BETWEEN);

        Div dateBox = new Div();
        dateBox.addClassName("date-box");

        Div dayText = new Div();
        dayText.setText(String.valueOf(appointment.getTime().getDayOfMonth()));
        dayText.addClassName("date-day");

        Div monthText = new Div();
        monthText.addClassName("date-month");
        monthText.setText(String.valueOf(appointment.getTime().getMonth()));

        dateBox.add(dayText, monthText);

        Div content = new Div();
        content.setWidthFull();
        content.addClassName("list-content");

        String time = appointment.getTime().getHour() + ":" + appointment.getTime().getMinute();
        String client = String.valueOf(appointment.getHealthClient().getFullName());

        Div title = new Div();
        title.setText(time + " - " + client );
        title.setWidthFull();

        Div address = new Div();
        address.setText(appointment.getHealthClient().getAddress().toString());
        address.setWidthFull();

        content.add(title, address);

        Icon icon = new Icon(VaadinIcon.ANGLE_RIGHT);
        icon.addClassName("icon-grey");
        setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, icon);

        add(dateBox, content, icon);

    }
}
