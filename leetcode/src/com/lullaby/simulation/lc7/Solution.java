package com.lullaby.simulation.lc7;

class Solution {
    public int reverse(int x) {
        boolean simple = true;
        String src = "" + x;
        int left = 0;
        int right = src.length() - 1;
        char[] chars = src.toCharArray();
        if (x == 0) return 0;
        if (x < 0) {
            simple = false;
            left++;
        }
        int start = left;
        while (src.charAt(right) == '0') {
            right--;
        }

        int count = right;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        long res = 0;
        for (; start <= count; start++) {
            res = res * 10 + (chars[start] - '0');
        }
        if (!simple) {
            res = -res;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)res;
    }

}
