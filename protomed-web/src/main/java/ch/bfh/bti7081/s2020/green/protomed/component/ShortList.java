package ch.bfh.bti7081.s2020.green.protomed.component;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public abstract class ShortList extends VerticalLayout {
    public ShortList(String title, String path, int count) {
        HorizontalLayout header = new HorizontalLayout();

        header.setWidthFull();
        header.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        H3 h3 = new H3(title);
        h3.setWidthFull();
        header.add(h3);

        Anchor anchor = new Anchor(path, "Alle anzeigen (" + count + ")");
        header.setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, anchor);
        header.add(anchor);

        add(header);
    }
}
