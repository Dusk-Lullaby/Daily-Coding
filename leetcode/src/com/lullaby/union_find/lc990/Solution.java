package com.lullaby.union_find.lc990;

class Solution {

    public int[] parent;

    public int count;

    public boolean equationsPossible(String[] equations) {
        count = 26;
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }

        String[] sign = new String[equations.length];
        int length = 0;
        for (String string : equations) {
            int num1 = string.charAt(0) - 'a';
            int num2 = string.charAt(3) - 'a';
            boolean isEqual = string.charAt(1) == '=';
            if (isEqual) {
                union(num1, num2);
            } else {
                sign[length++] = string;
            }
        }
        for (int i = 0; i < length; i++) {
            String string = sign[i];
            int num1 = string.charAt(0) - 'a';
            int num2 = string.charAt(3) - 'a';
            int rootA = find(num1);
            int rootB = find(num2);
            if (rootA == rootB) return false;
        }
        return true;
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }

    public int find(int a) {
        return parent[a] == a ? parent[a] : find(parent[a]);
    }
}