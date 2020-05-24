package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolDetailViewImplementation;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ProtocolDetail extends Div {

    TextField inpHealthvisitorName;

    public ProtocolDetail(ProtocolDetailViewImplementation viewImplementation){
        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();

        H3 title = new H3("Protocol XY");
        layout.add(title);

        Label lblHealthVisitor = new Label("Healthvisitor:");
        inpHealthvisitorName = new TextField();
        layout.add(lblHealthVisitor);
        layout.add(inpHealthvisitorName);

        borderBox.add(layout);
        borderBox.addClassName("panel");

        setReadOnly();
        add(borderBox);
        addClassName("panel-box");
    }

    public void loadProtocolDetails(Protocol protocol) {
        inpHealthvisitorName.setValue(protocol.getHealthVisitor().getFullName());
    }

    private void setReadOnly() {
        inpHealthvisitorName.setEnabled(false);
    }

}
