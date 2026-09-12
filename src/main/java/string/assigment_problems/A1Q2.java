public class A1Q2 {
    public static void checkTypingAccuracy(String original, String typed) {
        int totalChars = original.length();
        int matchedChars = 0;
        int firstMismatchPos = -1;

        for (int i = 0; i < totalChars; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (origChar == typedChar) {
                matchedChars++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
            }
        }

        double accuracy = ((double) matchedChars / totalChars) * 100;

        StringBuilder output = new StringBuilder();
        output.append(String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matchedChars, totalChars, accuracy));

        if (firstMismatchPos == -1) {
            output.append("No Mismatches");
        } else {
            output.append(String.format("First Mismatch at position %d ('%c' vs '%c')",
                    firstMismatchPos, original.charAt(firstMismatchPos - 1), typed.charAt(firstMismatchPos - 1)));
        }

        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}