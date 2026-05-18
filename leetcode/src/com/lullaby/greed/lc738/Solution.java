package com.lullaby.greed.lc738;

//class Solution {
//    public int monotoneIncreasingDigits(int n) {
//        if (n == 10) return 9;
//        char[] number = ("" + n).toCharArray();
//        int digits = number.length;
//        char max = '0';
//        for (int i = 0; i < number.length; i++) {
//            char c = number[i];
//            // 找到非递增
//            if (c >= max) {
//                max = c;
//                // 352 -> 349
//                //   |
//            } else {
//                // 最后递增位置
//                i--;
//                // 13 15
//                // 最后递增位置是第一位
//                if (i == 0) {
//                    // 最后递增位 - 1，后面的位置都为9
//                    number[i]--;
//                    while (i < digits - 1) {
//                        number[++i] = '9';
//                    }
//                    return Integer.parseInt(new String(number));
//                    // 343 -> 339
//                    // 332 -> 329
//                    // 33332 -> 29999
//                // 最后递增位置不是第一位
//                } else {
//                    // 342 ->
//                    // 右边小于左边
//                    // 找到左边大于右边-1的最大位置
//                    while (i >= 1 && number[i] <= number[i - 1]) {
//                        i--;
//                    }
//                    // 最后位置-1，其他位置变为9
//                    number[i]--;
//                    // 123 3
//                    while (i < digits - 1) {
//                        number[++i] = '9';
//                    }
//                    return Integer.parseInt(new String(number));
//                }
//            }
//        }
//        return n;
//    }
//}


class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = new String("" + n).toCharArray();
        int num29 = chars.length;
        for (int i = num29 - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                chars[i - 1]--;
                num29 = i;
            }
        }

        for (int i = num29; i < chars.length; i++) {
            chars[i] = '9';
        }

        return Integer.parseInt(new String(chars));
    }
}