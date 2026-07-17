package com.lullaby.greed.lc1663;

import java.util.Arrays;

class Solution {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        int num = n;
        Arrays.fill(res, 'a');
        int p = n - 1;
        while (num < k) {
            int diff = k - num;
            if (diff < 26) {
                res[p] = (char)('a' + diff);
                num += diff;
            } else {
                res[p--] = 'z';
                num += 25;
            }
        }
        return String.valueOf(res);
    }
}