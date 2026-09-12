import java.util.*;
public class week4qs4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter elements of the first array");
        for(int i=0;i<n1;i++){
            nums1[i]=sc.nextInt();
        }   
        System.out.println("Enter the size of the array");
        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter elements of the second array");
        for(int i=0;i<n2;i++){
            nums2[i]=sc.nextInt();
        }  

        int res=mergeArr(nums1,nums2);


    }

    public static int mergeArr(int[] nums1,int[] nums2){
        int n1=nums1.length;
        int n2=nums2.length;
        int[] merged = new int[n1+n2];
        for(int i=0;i<n1;i++){
            merged[i]=nums1[i];
        }
        for(int i=0;i<n2;i++){
            merged[n1+i]=nums2[i];
        }
        Arrays.sort(merged);
        System.out.println("Merged and sorted array is:");
        for(int i=0;i<merged.length;i++){
            System.out.print(merged[i]+" ");
        }
        return 0;
    }
}
