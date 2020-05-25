package ch.bfh.bti7081.s2020.green.protomed.view.appointment.main;

import ch.bfh.bti7081.s2020.green.protomed.component.AppointmentListItem;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.view.appointment.AppointmentView;
import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.List;

public class AppointmentViewImplementation extends VerticalLayout implements AppointmentView {

    private List<AppointmentViewListener> listeners = new ArrayList<>();
    private VerticalLayout appointmentList;

    public AppointmentViewImplementation() {

        add(new H2("Nächste Termine"));

        TextField search = new TextField();

        search.setPlaceholder("Suche Termin");
        search.setAutoselect(true);
        search.addValueChangeListener(e -> {
            for (AppointmentViewListener listener : listeners) {
                listener.setSearchValue(e.getValue().toString());
            }
        });
        search.setWidthFull();

        add(search);

        appointmentList = new VerticalLayout();
        appointmentList.setWidthFull();
        appointmentList.setMargin(false);
        appointmentList.setPadding(false);
        add(appointmentList);

    }

    public void updateAppointmentList(List<Appointment> appointments) {
        appointmentList.removeAll();
        for (Appointment appointment : appointments) {
            ClickableCard appointmentCard = new ClickableCard(
                    onClick -> {
                        for (AppointmentViewListener listener : listeners)
                            listener.selectAppointment(appointment);
                    },
                    new AppointmentListItem(appointment)
            );
            appointmentCard.setWidthFull();
            appointmentList.add(appointmentCard);
        }
    }

    public void navigateToAppointment(Long id) {
        UI.getCurrent().navigate("appointment/" + Long.toString(id));
    }

    @Override
    public void addListener(AppointmentViewListener listener) {
        listeners.add(listener);
    }
}
