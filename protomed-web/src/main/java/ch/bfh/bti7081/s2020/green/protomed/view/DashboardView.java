package ch.bfh.bti7081.s2020.green.protomed.view;

import com.vaadin.flow.router.Route;


public interface DashboardView {

    interface DashboardViewListener {
//        void click(String a);
    }

    public void addListener(DashboardViewListener listener);

}
