package com.lullaby.graph.lc1615;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connect = new boolean[n][n];
        int[] degree = new int[n];
        for (int[] vertex : roads) {
            connect[vertex[0]][vertex[1]] = true;
            connect[vertex[1]][vertex[0]] = true;
            degree[vertex[0]]++;
            degree[vertex[1]]++;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = degree[i] + degree[j];
                if (connect[i][j]) {
                    d--;
                }
                answer = Math.max(answer, d);
            }
        }
        return answer;
    }
}


//import java.util.ArrayList;
//import java.util.List;
//
//class Solution {
//    public int maximalNetworkRank(int n, int[][] roads) {
//        boolean[][] connect = new boolean[n][n];
//        int[] degree = new int[n];
//        for (int[] vertex : roads) {
//            connect[vertex[0]][vertex[1]] = true;
//            connect[vertex[1]][vertex[0]] = true;
//            degree[vertex[0]]++;
//            degree[vertex[1]]++;
//        }
//        int max1 = 0;
//        int index1 = -1;
//        int max2 = 0;
//        int index2 = -1;
//        for (int i = 0; i < n; i++) {
//            if (max1 < degree[i]) {
//                max1 = degree[i];
//                index1 = i;
//            }
//        }
//        List<Integer> i1 = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (max1 == degree[i]) {
//                i1.add(i);
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (max2 < degree[i] && i != index1) {
//                max2 = degree[i];
//                index2 = i;
//            }
//        }
//        List<Integer> i2 = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (max2 == degree[i]) {
//                i2.add(i);
//            }
//        }
//
//    }
//}
