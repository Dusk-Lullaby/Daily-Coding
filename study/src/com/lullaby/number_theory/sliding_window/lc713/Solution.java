package com.lullaby.number_theory.sliding_window.lc713;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int multiply = 1;
        int ans = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            multiply *= nums[r];
            if (multiply >= k) {
                while (r >= l && multiply >= k) {
                    multiply /= nums[l++];
                }
            }
            if (r >= l) {
                ans += r - l + 1;
            }
            r++;
        }
        return ans;
    }
}