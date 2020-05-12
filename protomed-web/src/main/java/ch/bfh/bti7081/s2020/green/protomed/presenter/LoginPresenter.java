package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
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

    @Override
    public void loginClick(String email, String password) {
        if (!model.validateEmail(email)) {
            view.showInvalidEmail();
        } else if (model.authenticate(email, password)) {
            view.navigateToDashboard();
        } else {
            view.showDeniedAccess();
        }
    }
}
