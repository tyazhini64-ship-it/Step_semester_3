public class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.combination.equals(currentCode)) {
            this.combination = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return this.lockerNumber;
    }
}