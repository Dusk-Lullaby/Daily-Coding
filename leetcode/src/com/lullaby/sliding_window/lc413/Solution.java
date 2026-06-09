package com.lullaby.sliding_window.lc413;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int ans = 0;
        int dif = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dif++;
                ans += dif;
            } else {
                dif = 0;
            }
        }
        return ans;

    }
}