package Assignment.Day4;



//leetcode-888
//  Fair Candy Swap
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Set<Integer> setB = new HashSet<>();

        // Calculate sums
        for (int a : A) {
            sumA += a;
        }

        for (int b : B) {
            sumB += b;
            setB.add(b);
        }

        // b - a = (sumB - sumA) / 2
        int delta = (sumB - sumA) / 2;

        // Find the pair
        for (int a : A) {
            int b = a + delta;

            if (setB.contains(b)) {
                return new int[] {a, b};
            }
        }

        return new int[0];
    }
}