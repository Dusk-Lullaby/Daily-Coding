package com.lullaby.greed.lc45;

// DP
//class Solution {
//    public int jump(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, 0x3f3f3f3f);
//        dp[0] = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int distance = nums[i];
//            for (int j = 1; j <= distance; j++) {
//                if (i + j < nums.length)
//                    dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
//            }
//        }
//        return dp[nums.length - 1];
//    }
//}



// greed
class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int maxDistance = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (i == end) {
                end = maxDistance;
                step++;
            }
        }
        return step;
    }
}