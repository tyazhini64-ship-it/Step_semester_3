import java.util.*;

public class week4qs1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter size: ");
        int n = sc.nextInt();
        
        int[] nums = new int[n]; 
        
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        System.out.println("Enter target: ");
        int target = sc.nextInt();
        
        int[] result = twoSum(nums, target);
        
        if (result.length == 2) {
            System.out.println("The indices are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
        
        sc.close();
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; 
    }
}