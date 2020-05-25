package ch.bfh.bti7081.s2020.green.protomed.view.login;

public interface LoginView {

    interface LoginViewListener {
        void loginClick(String userName, String password);
    }

    void addListener(LoginViewListener listener);

    void showInvalidEmail();

    void showDeniedAccess();

    void navigateToDashboard();

}
