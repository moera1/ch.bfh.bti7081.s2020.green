package ch.bfh.bti7081.s2020.green.protomed.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Overview extends Div {

    public Overview() {
        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();
        H3 title = new H3("Overview/Charts");

        layout.add(title);
        borderBox.add(layout);
        borderBox.addClassName("panel");

        add(borderBox);
        addClassName("panel-box");

    }
}
