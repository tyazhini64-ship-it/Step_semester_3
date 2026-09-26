public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (this.password == null) {
            return "Weak";
        }
        
        int length = this.password.length();
        if (length < 6) {
            return "Weak";
        } else if (length >= 6 && length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}