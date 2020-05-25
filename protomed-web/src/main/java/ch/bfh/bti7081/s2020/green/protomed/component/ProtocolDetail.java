package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.model.ProtocolType;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class ProtocolDetail extends Div {

    TextField txtHealthvisitorName;
    TextField txtHealthclientName;
    TextArea txaProtocolContent;
    TextField txtCreationDate;
    TextField txtProtocolType;

    Label lblAppointmentDateTime;
    TextField txtAppointmentDateTime;

    private Boolean isExtended = false;
    private Boolean isReadOnly;

    public ProtocolDetail(boolean readonly) {
        this.isReadOnly = readonly;
        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();

        H3 title = new H3("Protocol XY");
        layout.add(title);

        Label lblHealthVisitorName = new Label("Healthvisitor:");
        txtHealthvisitorName = new TextField();
        layout.add(lblHealthVisitorName);
        layout.add(txtHealthvisitorName);

        Label lblHealthClientName = new Label("Healhtclient:");
        txtHealthclientName = new TextField();
        layout.add(lblHealthClientName);
        layout.add(txtHealthclientName);

        Label lblProtocolContent = new Label("Beschreibung:");
        txaProtocolContent = new TextArea();
        txaProtocolContent.setWidthFull();
        layout.add(lblProtocolContent);
        layout.add(txaProtocolContent);

        Label lblCreationDate = new Label("Erstellungsdatum:");
        txtCreationDate = new TextField();
        layout.add(lblCreationDate);
        layout.add(txtCreationDate);

        Label lblProtocolType = new Label("Typ:");
        txtProtocolType = new TextField();
        layout.add(lblProtocolType);
        layout.add(txtProtocolType);

        // ---------------------------- //
        //       Extended fields        //
        // ---------------------------- //

        lblAppointmentDateTime = new Label("Termin:");
        lblAppointmentDateTime.setVisible(false);
        txtAppointmentDateTime = new TextField();
        txtAppointmentDateTime.setVisible(false);

        layout.add(lblAppointmentDateTime);
        layout.add(txtAppointmentDateTime);

        if (this.isReadOnly) setReadOnly();

        borderBox.add(layout);
        borderBox.addClassName("panel");

        add(borderBox);
        addClassName("panel-box");
    }

    public void loadProtocolDetails(Protocol protocol) {
        txtHealthvisitorName.setValue(protocol.getHealthVisitor().getFullName());
        txtHealthclientName.setValue(protocol.getHealthClient().getFullName());
        if (protocol.getContent() != null) {
            txaProtocolContent.setValue(protocol.getContent());
        }
        txtCreationDate.setValue(protocol.getCreationDate().toString());
        txtProtocolType.setValue(protocol.getProtocolType().toString());

        if (protocol.getProtocolType().equals(ProtocolType.BESUCH)) {
            this.isExtended = true;
            enableExtendedFields();
            txtAppointmentDateTime.setValue(protocol.getAppointment().getTime().toString());
        }
    }

    private void enableExtendedFields() {
        lblAppointmentDateTime.setVisible(true);
        txtAppointmentDateTime.setVisible(true);
    }

    private void setReadOnly() {
        txtHealthvisitorName.setEnabled(false);
        txtHealthclientName.setEnabled(false);
        txaProtocolContent.setEnabled(false);
        txtCreationDate.setEnabled(false);
        txtProtocolType.setEnabled(false);
        txtAppointmentDateTime.setEnabled(false);
    }

}
