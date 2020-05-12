package ch.bfh.bti7081.s2020.green.protomed.view;

public interface LoginView  {

    interface LoginViewListener {
        void loginClick(String userName, String password);
    }

    public void addListener(LoginViewListener listener);

    public void showInvalidEmail();

    public void showDeniedAccess();

    public void navigateToDashboard();

}
