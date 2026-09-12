public class A1Q3 {
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data provided.");
            return;
        }

        char maxStreakChar = signalLog.charAt(0);
        int maxStreakLength = 1;

        char currentStreakChar = signalLog.charAt(0);
        int currentStreakLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char currentChar = signalLog.charAt(i);

            if (currentChar == currentStreakChar) {
                currentStreakLength++;
            } else {
                if (currentStreakLength > maxStreakLength) {
                    maxStreakLength = currentStreakLength;
                    maxStreakChar = currentStreakChar;
                }
                currentStreakChar = currentChar;
                currentStreakLength = 1;
            }
        }

        if (currentStreakLength > maxStreakLength) {
            maxStreakLength = currentStreakLength;
            maxStreakChar = currentStreakChar;
        }

        System.out.println("Longest Streak: '" + maxStreakChar + "' repeated " + maxStreakLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}