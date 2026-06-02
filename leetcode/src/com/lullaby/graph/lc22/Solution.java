package com.lullaby.graph.lc22;

import java.util.ArrayList;
import java.util.List;

// DFS
//class Solution {
//    int left = 0;
//    int right = 0;
//    List<String> ans = new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        char[] chars = new char[n * 2];
//        chars[left++] = '(';
//        dfs(chars, 1, n);
//        return ans;
//    }
//
//    public void dfs(char[] chars, int step, int n) {
//        if (step == n * 2) {
//            ans.add(new String(chars));
//            return;
//        }
//        if (left < n) {
//            chars[step] = '(';
//            left++;
//            dfs(chars, step + 1, n);
//            left--;
//        }
//        if (right < n && right < left) {
//            chars[step] = ')';
//            right++;
//            dfs(chars, step + 1, n);
//            right--;
//        }
//    }
//}



// DP
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>[] DP = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            DP[i] = new ArrayList<>();
        }
        DP[0].add("");
        DP[1].add("()");
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                for (String left : DP[j]) {
                    for (String right : DP[i - j - 1]) {
                        String s = "(" + left + ")" + right;
                        DP[i].add(s);
                    }
                }
            }
        }

        return DP[n];
    }
}
