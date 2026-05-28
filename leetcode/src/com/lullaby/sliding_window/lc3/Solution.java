package com.lullaby.sliding_window.lc3;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] number = new int[200];
        int r = 0;
        int l = -1;
        int len = 0;
        int ans = 0;
        for (r = 0; r < s.length(); r++) {
            number[s.charAt(r)]++;
            while (r > l && number[s.charAt(r)] > 1){
                number[s.charAt(++l)]--;
            }
            len = r - l;
            ans = Math.max(ans, len);
        }

        return ans;
    }
}