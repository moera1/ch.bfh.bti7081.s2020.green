package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.view.DashboardView;

public class DashboardPresenter implements DashboardView.DashboardViewListener {

    private DashboardView view;

    public DashboardPresenter(DashboardView view) {
        this.view = view;
        view.addListener(this);
    }
}
