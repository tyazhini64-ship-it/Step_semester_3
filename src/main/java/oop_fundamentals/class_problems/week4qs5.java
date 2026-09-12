import java.util.*;

public class week4qs5 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size: ");
        int n = sc.nextInt();
        int[] num = new int[n];
        
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        
        System.out.println("Enter number of rotations: ");
        int k = sc.nextInt();
        
        int[] res = rotate(num, k);
        
        System.out.println("Rotated array is: ");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

        sc.close();
    }

    public static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        
        k = k % n;
        if (k < 0) {
            k = k + n;
        }

        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        return newArr;
    }
}