package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.model.Login;
import ch.bfh.bti7081.s2020.green.protomed.view.LoginView;
import ch.bfh.bti7081.s2020.green.protomed.view.LoginViewImplementation;

public class LoginPresenter implements LoginView.LoginViewListener {

    private Login model;
    private LoginViewImplementation view;

    public LoginPresenter(Login model, LoginViewImplementation view) {
        this.model = model;
        this.view = view;
        view.addListener(this);
    }

    // TODO
    @Override
    public void loginClick(String userName, String password) {
        if (model.verifyUser(userName)) {
            if (model.verifyAccess(userName, password)) {
                view.navigateToDashboard();
            } else {
                view.showDeniedAccess();
            }
        } else {
            view.showInvalidUser();
        }
    }
}
