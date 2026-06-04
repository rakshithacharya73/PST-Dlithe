package PSTDSA.Day6;
//leetcode-300
//Length Longest Subsequence
import java.util.Arrays;

public class lengthLongestSubsequence {
    public static int findLength(int[] arr) {
        int size = arr.length, mlength = 1; 
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        for (int index = 1; index < size; index++) {
            for (int comp = 0; comp < index; comp++) {
                if (arr[index] > arr[comp])
                    dp[index] = Math.max(dp[index], dp[comp] + 1);

            }
            mlength = Math.max(mlength, dp[index]);
        }
        return mlength;  
    }

    public static void main(String[] args) {
        int[] inp = { 0, 1, 0, 3, 2, 3 };
        System.out.println(findLength(inp));
    }
}
