package ch.bfh.bti7081.s2020.green.protomed.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.RouterLayout;

import java.util.ArrayList;
import java.util.List;

public class LoginViewImplementation extends VerticalLayout implements RouterLayout, LoginView {

    private List<LoginView.LoginViewListener> listeners = new ArrayList<LoginView.LoginViewListener>();

    private H3 title = new H3("Protomed v0.0.1");
    private TextField userName = new TextField("Benutzername");
    private PasswordField password = new PasswordField("Passwort");
    private Button loginButton = new Button("Anmelden");

    public LoginViewImplementation() {
        loginButton.addClickListener( event -> {
            for (LoginViewListener listener : listeners)
                listener.loginClick(userName.getValue(), password.getValue());
        });

        add(title, userName, password, loginButton);

    }

    @Override
    public void showInvalidUser() {
        userName.setErrorMessage("Bitte Benutzername eingeben");
        userName.setInvalid(true);
    }

    @Override
    public void showDeniedAccess() {
        password.clear();
        password.setErrorMessage("Ungültiges Password");
        password.setInvalid(true);
    }

    @Override
    public void navigateToDashboard() {
        UI.getCurrent().navigate(DashboardView.class);
    }

    @Override
    public void addListener(LoginView.LoginViewListener listener) {
        listeners.add(listener);
    }

}
