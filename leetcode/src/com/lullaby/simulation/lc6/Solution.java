package com.lullaby.simulation.lc6;

import java.util.ArrayList;
import java.util.List;


/*

123456789 3

1   5     10    14       19
2 4 6   9 11 13 15    18 20
3   7 8   12    16 17    21

 */


/*
       方法2
 */
class Solution {
    public String convert(String s, int numRows) {
        int row  =0;
        List<List<Character>> lists = new ArrayList<>();
        if (numRows == 1) return s;
        for (int i = 0; i < numRows; i++) {
            lists.add(new ArrayList<>());
        }
        boolean isDown = true;
        for (int i = 0; i < s.length(); i++) {
            lists.get(row).add(s.charAt(i));
            if (row == numRows - 1) {
                isDown = false;
            } else if (row == 0) {
                isDown = true;
            }
            row += isDown ? 1 : -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Character> list : lists) {
            for (Character c : list) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}



/*
    方法一
 */
//class Solution {
//    public String convert(String s, int numRows) {
//        int row  =0;
//        List<List<Character>> lists = new ArrayList<>();
//        if (numRows == 1) return s;
//        for (int i = 0; i < numRows; i++) {
//            lists.add(new ArrayList<>());
//        }
//        boolean isDown = true;
//        for (int i = 0; i < s.length(); i++) {
//            if (isDown) {
//                lists.get(row++).add(s.charAt(i));
//                if (row == numRows - 1)
//                    isDown = false;
//            } else {
//                lists.get(row).add(s.charAt(i));
//                for (int j = 0; j < numRows; j++) {
//                    if (j != row)
//                        lists.get(j).add('@');
//                }
//                row--;
//                if (row == 0) {
//                    isDown = true;
//                }
//            }
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for (List<Character> list : lists) {
//            for (Character c : list) {
//                if (c != '@') {
//                    stringBuilder.append(c);
//                }
//            }
//        }
//        return stringBuilder.toString();
//    }
//}
