package ch.bfh.bti7081.s2020.green.protomed.view.login;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.List;

public class LoginViewImplementation extends VerticalLayout implements LoginView {

    private List<LoginView.LoginViewListener> listeners = new ArrayList<LoginView.LoginViewListener>();

    private H3 title = new H3("Protomed v0.0.1");
    private TextField emailField = new TextField("Email");
    private PasswordField passwordField = new PasswordField("Passwort");
    private Button loginButton = new Button("Anmelden");

    public LoginViewImplementation() {

        // DEBUG
        emailField.setValue("trudi@bfh-test.ch");
        passwordField.setValue("1234");

        loginButton.addClickListener(event -> {
            for (LoginViewListener listener : listeners)
                listener.loginClick(emailField.getValue(), passwordField.getValue());
        });

        title.addClassName("login-title");
        loginButton.addClassName("login-btn");
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);


        add(title, emailField, passwordField, loginButton);

        setSpacing(false);
        setPadding(false);
        setAlignItems(Alignment.CENTER);

    }

    @Override
    public void showInvalidEmail() {
        emailField.setErrorMessage("Bitte Email eingeben");
        emailField.setInvalid(true);
    }

    @Override
    public void showDeniedAccess() {
        passwordField.clear();
        passwordField.setErrorMessage("Ungültiges Password");
        passwordField.setInvalid(true);
    }

    @Override
    public void navigateToDashboard() {
        this.getUI().ifPresent(ui ->
                ui.navigate("dashboard"));
    }

    @Override
    public void addListener(LoginView.LoginViewListener listener) {
        listeners.add(listener);
    }

}
