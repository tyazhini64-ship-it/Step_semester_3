public class A1Q4 {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sumA = 0;
        int sumB = 0;

        int highestQty = Integer.MIN_VALUE;
        String highestSection = "";
        int highestItemIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            sumA += sectionA[i];
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestSection = "Section A";
                highestItemIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            sumB += sectionB[i];
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestSection = "Section B";
                highestItemIndex = i + 1;
            }
        }

        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + sumA +
                " | Section B Total: " + sumB +
                " | Status: " + status +
                " | Highest Quantity: " + highestQty +
                " (" + highestSection + ", Item " + highestItemIndex + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}