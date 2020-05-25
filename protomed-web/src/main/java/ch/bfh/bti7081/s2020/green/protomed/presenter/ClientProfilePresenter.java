package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.view.client.ClientProfileView;

public class ClientProfilePresenter implements ClientProfileView.ClientProfileViewListener {
    private ClientProfileView view;

    public ClientProfilePresenter(ClientProfileView view) {
        this.view = view;
        view.addListener(this);
    }
}
