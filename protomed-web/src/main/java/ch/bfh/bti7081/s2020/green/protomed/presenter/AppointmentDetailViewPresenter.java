package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.view.appointment.AppointmentDetailsView;
import ch.bfh.bti7081.s2020.green.protomed.view.appointment.details.AppointmentDetailsViewImplementation;

public class AppointmentDetailViewPresenter implements AppointmentDetailsView.AppointmentDetailsViewListener {
    private AppointmentDetailsView view;

    public AppointmentDetailViewPresenter(AppointmentDetailsViewImplementation view) {
        this.view = view;
        view.addListener(this);
    }
}
