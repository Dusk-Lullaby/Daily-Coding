package com.lullaby.graph.lc684;

/**
 * 并查集
 * O(NlgN)
 */
class Solution {

    static class UnionFind {
        int[] parent;

        public UnionFind(int count) {
            parent = new int[count + 1];
            for (int i = 1; i <= count; i++) {
                parent[i] = i;
            }
        }

        public int findRoot(int index) {
            if (parent[index] != index) {
               parent[index] = findRoot(parent[index]);
            }
            return parent[index];
        }

        public boolean union(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if (rootA == rootB) return false;
            parent[rootA] = rootB;
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        int[] ans = new int[2];
        for (int[] info : edges) {
            if (!uf.union(info[0], info[1])) {
                ans = info;
            }
        }

        return ans;
    }
}