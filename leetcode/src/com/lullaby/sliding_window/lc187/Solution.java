package com.lullaby.sliding_window.lc187;

import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 10) return ans;
        String string = "";
        int r = 0;
        for (r = 0; r < 10; r++) {
            string += s.charAt(r);
        }
        Map<String, Integer> map = new HashMap<>();
        for (r = 10; r <= s.length(); r++) {
            string = s.substring(r - 10, r);
            int count = map.getOrDefault(string, 0);
            map.put(string, ++count);
            if (count == 2) {
                ans.add(string);
            }
        }
        return ans;
    }
}