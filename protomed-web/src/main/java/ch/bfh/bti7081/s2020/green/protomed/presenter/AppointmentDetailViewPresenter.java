package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.view.AppointmentDetailsView;
import ch.bfh.bti7081.s2020.green.protomed.view.AppointmentDetailsViewImplementation;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.QueryParameters;

public class AppointmentDetailViewPresenter implements AppointmentDetailsView.AppointmentDetailsViewListener {
    private AppointmentDetailsView view;

    public AppointmentDetailViewPresenter(AppointmentDetailsViewImplementation view) {
        this.view = view;
        view.addListener(this);
        view.loadCreateProtocolView();
    }

    @Override
    public void navigateToProtocolCreateView(Appointment appointment) {
        UI.getCurrent().navigate("protocol-create/"+appointment.getId());
    }
}
