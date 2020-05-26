package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.AppointmentsShortList;
import ch.bfh.bti7081.s2020.green.protomed.component.NotificationsShortList;
import ch.bfh.bti7081.s2020.green.protomed.component.PersonContactCard;
import ch.bfh.bti7081.s2020.green.protomed.component.ProtocolsShortList;
import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class AppointmentDetailsViewImplementation extends VerticalLayout implements AppointmentDetailsView {
    private List<AppointmentDetailsViewListener> listeners = new ArrayList<>();

    public AppointmentDetailsViewImplementation(List<Appointment> appointments) {

    }

    @Override
    public void addListener(AppointmentDetailsViewListener listener) {
        listeners.add(listener);
    }

}
