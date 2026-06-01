
//leetcode - 414
//Third Maximum Number
class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long s_max = Long.MIN_VALUE;
        long t_max = Long.MIN_VALUE;

        for (int num : nums) {

            if (num > max) {
                t_max = s_max;
                s_max = max;
                max = num;

            } else if (num > s_max && num != max) {
                t_max = s_max;
                s_max = num;

            } else if (num > t_max && num != s_max && num != max) {
                t_max = num;
            }
        }

        return t_max != Long.MIN_VALUE ? (int) t_max : (int) max;
    }
}