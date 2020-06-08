package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.view.ClientProfileView;

public class ClientProfilePresenter implements ClientProfileView.ClientProfileViewListener {
    public ClientProfilePresenter(ClientProfileView view) {
        view.addListener(this);
    }
}
