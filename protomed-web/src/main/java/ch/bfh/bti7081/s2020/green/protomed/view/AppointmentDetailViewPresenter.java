package ch.bfh.bti7081.s2020.green.protomed.view;

public class AppointmentDetailViewPresenter implements AppointmentDetailsView.AppointmentDetailsViewListener {
    private AppointmentDetailsView view;

    public AppointmentDetailViewPresenter(AppointmentDetailsViewImplementation view) {
        this.view = view;
        view.addListener(this);
    }
}
