package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolDetailViewImplementation;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ProtocolDetail extends Div {

    H3 title;

    public ProtocolDetail(ProtocolDetailViewImplementation viewImplementation){
        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();

        title = new H3("Protocol XY");

        layout.add(title);
        borderBox.add(layout);
        borderBox.addClassName("panel");

        add(borderBox);
        addClassName("panel-box");
    }

}
