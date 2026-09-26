public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxCapacity) {
        this.presentStudents = new String[maxCapacity];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }
        if (this.count < this.presentStudents.length) {
            this.presentStudents[this.count] = name;
            this.count++;
        }
    }

    public int getPresentCount() {
        return this.count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < this.count; i++) {
            if (this.presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}