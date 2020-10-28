package algorithm;

import java.io.IOException;
import java.util.Scanner;

//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
//        示例 1：
//        输入：[-4,-1,0,3,10]
//        输出：[0,1,9,16,100]

public class ArrSquare {
    public static int[] sortedSquares(int[] A) {
        int start = 0;
        int end = A.length;
        int i = end - 1;
        int[] nums = new int[end--];
        while (i >= 0) {
            nums[i--] = A[start]*A[start] >= A[end]*A[end] ? A[start]*A[start++] : A[end]*A[end--];
        }
        return nums;
    }

    public static void main(String[] args) throws IOException {
        Scanner cin = new Scanner(System.in);
        String input = cin.next();
        String[] string = input.split(",");
        int[] A = new int[string.length];
        int[] T = new int[string.length];

        for (int i = 0; i<string.length; i++){
            A[i] = Integer.parseInt(string[i]);
        }
        T = sortedSquares(A);
        for(int i = 0; i<A.length; i++){
            System.out.print(T[i]+",");
        }
    }

}
