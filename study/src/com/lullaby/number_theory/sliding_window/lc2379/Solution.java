package com.lullaby.number_theory.sliding_window.lc2379;

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int min = 0x3f3f3f3f;
        for (r = 0; r < k; r++) {
            if (blocks.charAt(r) == 'W') {
                sum++;
            }
        }
        min = Math.min(min, sum);
        while (r < blocks.length()) {
            if (blocks.charAt(r++) == 'W') {
                sum++;
            }
            if (blocks.charAt(l++) == 'W') {
                sum--;
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}
