package ch.bfh.bti7081.s2020.green.protomed.view;

public interface ClientView {

    interface ClientViewListener {
//        void click(String a);
    }

    public void addListener(ClientViewListener listener);
}
