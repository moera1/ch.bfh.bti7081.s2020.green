package ch.bfh.bti7081.s2020.green.protomed.view;

public interface ClientProfileView {

    interface ClientProfileViewListener {
        //void click(String a);
    }

    public void addListener(ClientProfileViewListener listener);
}
