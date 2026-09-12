
import java.util.*;

public class week4qs3 {
    public static void main(String args[]){
        int[] nums = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements of the array");
        for(int i=0;i<10;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(Duplicate(nums));


        sc.close();

    }
    public static boolean Duplicate(int[] nums){
   
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    


}

