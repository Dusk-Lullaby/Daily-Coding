package com.lullaby.greed.lc1247;

class Solution {
    public int minimumSwap(String s1, String s2) {
        // xxxx yyyy
        // xyx yxy
        // yyx xxy
        // xyy yyx
        // yxy yyx
        // yyy xyx
        // yxy yyx

        // xxx yxy xy xy 1
        // xxy yxx xy yx 2
        int XY = 0;
        int YX = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (c1 == 'x' && c2 == 'y'){
                    XY++;
                } else {
                    YX++;
                }
            }
        }
        int ans = 0;

        while (XY >= 2) {
            XY -= 2;
            ans ++;
        }
        while (YX >= 2) {
            YX -= 2;
            ans++;
        }
        if (XY == 0 && YX == 0) {
            return ans;
        }

        if (XY == 1 && YX == 1) {
            ans += 2;
            XY--;
            YX--;
        } else {
            return -1;
        }
        return ans;
    }
}
