package ch.bfh.bti7081.s2020.green.protomed.model;

public class Login {

    public Login() {}

    // TODO
    public boolean verifyUser(String userName) {
        if (userName.isBlank()) {
            return false;
        }
        return true;
    }

    // TODO
    public boolean verifyAccess(String userName, String password) {
        if (password.isBlank()) {
            return false;
        }
        return true;
    }

}
