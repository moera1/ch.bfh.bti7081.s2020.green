package ch.bfh.bti7081.s2020.green.protomed.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarListItem extends Div {

    private SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    private SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");

    public CalendarListItem(String titleText, String address, String date) {
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
        add(listContent);
    }
}
