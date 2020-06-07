package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;

public interface AppointmentDetailsView {

    interface AppointmentDetailsViewListener {
        void navigateToProtocolCreateView(Appointment appointment);
    }

    public void addListener(AppointmentDetailsViewListener listener);

    void loadCreateProtocolView();
}
