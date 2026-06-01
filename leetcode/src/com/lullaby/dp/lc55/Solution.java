package com.lullaby.dp.lc55;

// 贪心
//class Solution {
//    public boolean canJump(int[] nums) {
//        int len = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i <= len) {
//                len = Math.max(len, i + nums[i]);
//            }
//        }
//        return len >= nums.length - 1;
//    }
//}


// DP
class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < i) return false;
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return true;
    }
}
