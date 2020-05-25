package ch.bfh.bti7081.s2020.green.protomed.model;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;

public class Login {

    private HealthVisitorManager healthVisitorManager = HealthVisitorManager.getInstance();

    public Login() {
    }

    public boolean validateEmail(String email) {
        return !email.isBlank();
    }

    public boolean verifyAccess(String userName, String password) {
        return !password.isBlank();
    }

    public boolean authenticate(String email, String password) {
        try {
            healthVisitorManager.logInUser(email, password);
            //DEBUG
            System.out.println(healthVisitorManager.getCurrentUser().getUsername());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
