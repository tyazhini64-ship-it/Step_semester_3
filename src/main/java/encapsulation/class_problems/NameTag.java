public class NameTag {
    private final String firstName;
    private final String lastInitial;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastInitial = String.valueOf(parts[1].charAt(0));
    }

    public String getNickname() {
        return this.firstName + " " + this.lastInitial + ".";
    }
}