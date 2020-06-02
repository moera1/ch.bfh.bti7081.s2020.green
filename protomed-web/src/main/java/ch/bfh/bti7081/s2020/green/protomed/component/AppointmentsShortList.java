package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.UI;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentsShortList extends ShortList {

    public AppointmentsShortList(List<Appointment> appointments) {

        super("Termine", "appointments", appointments.size());

        for (Appointment appointment : appointments.stream().limit(3).collect(Collectors.toList())) {
            ClickableCard appointmentCard = new ClickableCard(
                    onClick -> {
                        UI.getCurrent().navigate("appointment/" + Long.toString(appointment.getId()));
                    },
                    new AppointmentListItem(appointment)
            );
            appointmentCard.setWidthFull();
            add(appointmentCard);
        }
    }
}
