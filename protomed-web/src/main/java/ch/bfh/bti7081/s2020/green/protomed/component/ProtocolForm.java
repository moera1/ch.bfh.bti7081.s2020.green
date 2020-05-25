package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.model.*;
import ch.bfh.bti7081.s2020.green.protomed.view.protocol.ProtocolEditView;
import ch.bfh.bti7081.s2020.green.protomed.view.protocol.edit.ProtocolEditViewImplementation;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class ProtocolForm extends FormLayout {

    private ProtocolEditViewImplementation editView;

    private Binder<Protocol> binder = new Binder<>(Protocol.class);

    private Select<HealthClient> healthClient = new Select<>();
    private Select<ProtocolType> protocolType = new Select<>();
    private TextArea content = new TextArea("Inhalt");
    private CheckboxGroup<HealthService> services = new CheckboxGroup<>();
    private Select<Appointment> appointment = new Select<>();

    public TextField creator = new TextField();
    private DatePicker creationDateText = new DatePicker();
    private Button save = new Button("Speichern");
    private Button cancel = new Button("Abbrechen");
    private Button delete = new Button("Löschen");
    private Label infoLabel = new Label();

    public ProtocolForm(ProtocolEditViewImplementation editView) {

        this.editView = editView;

        healthClient.setLabel("Klient");

        creator.setLabel("Ersteller");
        creator.setReadOnly(true);

        protocolType.setLabel("Protokolltyp");
        protocolType.setEmptySelectionCaption("Protokolltyp wählen");
        protocolType.setItems(ProtocolType.values());

        creationDateText.setLabel("Erstellungsdatum");
        creationDateText.setReadOnly(true);

        content.setLabel("Beschrieb");
        content.getElement().setAttribute("colspan", "2");

        services.setLabel("Dienstleistungen");
        services.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        services.setItemLabelGenerator(HealthService::getServiceID);

        appointment.setLabel("Termin verknüpfen");
        appointment.setItemLabelGenerator(Appointment::getTimeAsString);

        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);

        HorizontalLayout formButtons = new HorizontalLayout(save, cancel, delete);

        add(creator, creationDateText, protocolType, healthClient, content, appointment, services, formButtons);

        setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("600px", 2));

        binder.bindInstanceFields(this);

        save.addClickListener(event -> {
            for (ProtocolEditView.ProtocolEditViewListener listener : editView.getListeners()) {
                listener.updateProtocol(binder.getBean());
            }
        });
        cancel.addClickListener(event -> {
            for (ProtocolEditView.ProtocolEditViewListener listener : editView.getListeners()) {
                listener.cancel(binder.getBean());
            }
        });
        delete.addClickListener(event -> {
            for (ProtocolEditView.ProtocolEditViewListener listener : editView.getListeners()) {
                listener.deleteProtocol(binder.getBean());
            }
        });
    }

    public void loadProtocolData(Protocol protocol) {
        creator.setValue(protocol.getHealthVisitor().getFullName());
        creationDateText.setValue(protocol.getCreationDate().toLocalDate());
        healthClient.setItems(HealthClientManager.getInstance().getHealthClients());

        // TODO: bind service checkboxgroup and appointments properly (needs 'fake' getter/setter as in HV/HC?)
//        binder.forField(services)
//              .bind(Protocol::getServices, Protocol::setServices);

        if (protocol.getProtocolType().equals(ProtocolType.BESUCH)) {
            appointment.setItems(ApplicationModelManager.getInstance().getAppointmentsByHealthClientID(protocol.getHealthClient().getPersonId()));
            services.setItems(protocol.getHealthClient().getInsuredServices());
        } else {
            remove(services, appointment);
        }
        binder.setBean(protocol);
    }

}
