package ch.bfh.bti7081.s2020.green.protomed.model;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;

public class Login {

    public Login() {
    }

    public boolean validateEmail(String email) {
        return email.isBlank() ? false : true;
    }

    public boolean verifyAccess(String userName, String password) {
        return password.isBlank() ? false : true;
    }

    public boolean authenticate(String email, String password) {
        try {
            HealthVisitorManager.getInstance().logInUser(email, password);
            //DEBUG
            System.out.println(HealthVisitorManager.getInstance().getCurrentUser().getUsername());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
