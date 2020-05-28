package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.view.AppointmentMainView;
import ch.bfh.bti7081.s2020.green.protomed.view.DashboardView;
import ch.bfh.bti7081.s2020.green.protomed.view.DashboardViewImplementation;
import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentOverview extends Div {

    private H3 title = new H3("Nächste Termine");
    private Button showAllButton;
    private Div appointmentContainer;
    private DashboardViewImplementation view;

    public AppointmentOverview(DashboardViewImplementation view) {
        // Register DashboardView to get access to the listeners
        this.view = view;

        Div borderBox = new Div();
        VerticalLayout layout = new VerticalLayout();

        Div panelContent = new Div();
        panelContent.addClassName("panel-content");
        panelContent.setSizeFull();

        showAllButton = new Button();
        showAllButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        showAllButton.addClassName("panel-btn");
        showAllButton.addClickListener( event -> UI.getCurrent().navigate(AppointmentMainView.class));

        appointmentContainer = new Div();
        appointmentContainer.addClassName("notification-container");

        panelContent.add(title, appointmentContainer, showAllButton);
        layout.add(panelContent);

        borderBox.add(layout);
        borderBox.addClassName("panel");

        add(borderBox);
        addClassName("panel-box");

    }

    // Shows the next two upcoming appointments of the user
    public void loadNextAppointments(List<Appointment> appointments) {
        appointmentContainer.removeAll();
        List<Appointment> nextAppointments = appointments
                .stream()
                .sorted(Comparator.comparing(Appointment::getTime))
                .limit(2)
                .collect(Collectors.toList());
        for (Appointment appointment : nextAppointments) {
            ClickableCard appointmentCard = new ClickableCard(
                    onClick -> {
                        for (DashboardView.DashboardViewListener listener : view.getListeners()) {
                            listener.selectAppointment(appointment);
                        }
                    },
                    new AppointmentListItem(appointment)
            );
            appointmentCard.setWidthFull();
            appointmentContainer.add(appointmentCard);

        }
        int size = appointments.size();
        showAllButton.setText("Alle anzeigen (" + size + ")");
    }
}
