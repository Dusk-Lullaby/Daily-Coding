package com.lullaby.greed.lc1529;

/*
       10111
       00000

       3

       01000
       00000

 */
class Solution {
    public int minFlips(String target) {
        int count = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (count % 2 != c - '0') {
                count++;
            }
        }
        return count;
    }
}