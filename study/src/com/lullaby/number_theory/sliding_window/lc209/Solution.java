package com.lullaby.number_theory.sliding_window.lc209;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int r = 0;
        int l = 0;
        int sum = 0;
        int ans = 0x3f3f3f3f;
        while (r < nums.length) {
            sum += nums[r];
            if (sum >= target) {
                while (l <= r && sum - nums[l] >= target) {
                    sum = sum - nums[l];
                    l++;
                }
                ans = Math.min(ans, r - l + 1);
            }
            r++;
        }
        return ans == 0x3f3f3f3f ? 0 : ans;
    }
}
