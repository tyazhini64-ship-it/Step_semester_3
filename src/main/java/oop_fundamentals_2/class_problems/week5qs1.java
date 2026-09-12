package week5.practice;

import java.util.Arrays;
import java.util.Scanner;

public class week5qs1 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter size of the array: ");
        int n=sc.nextInt();
        int[]scores=new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Value of index "+ i + " :");
            scores[i]=sc.nextInt();
        }
        System.out.print("Enter bonus: ");
        int bonus=sc.nextInt();
        curveScores(scores,bonus);
        System.out.println(Arrays.toString(scores));

    }
    public static void curveScores(int[] scores,int bonus){
        for(int i=0;i<scores.length;i++){
            scores[i]+=bonus;
        }

    }

}
