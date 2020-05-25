package ch.bfh.bti7081.s2020.green.protomed.view.appointment;

public interface AppointmentDetailsView {

    interface AppointmentDetailsViewListener {
        //void click(String a);
    }

    public void addListener(AppointmentDetailsViewListener listener);
}
