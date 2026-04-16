package com.lullaby.graph.lc210;

import java.util.*;

//class Solution {
//
//    List<List<Integer>> edges = new ArrayList<>();
//
//    int[] inDegree;
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        for (int i = 0; i < numCourses; i++) {
//            edges.add(new ArrayList<>());
//        }
//        inDegree = new int[numCourses];
//        for (int[] info : prerequisites) {
//            edges.get(info[1]).add(info[0]);
//            inDegree[info[0]]++;
//        }
//
//        int[] res = new int[numCourses];
//        int count = 0;
//        Deque<Integer> queue = new ArrayDeque<>();
//
//        for (int i = 0; i < numCourses; i++) {
//            if (inDegree[i] == 0) {
//                queue.offer(i);
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int num = queue.poll();
//            res[count++] = num;
//            for (int v : edges.get(num)) {
//                if (--inDegree[v] == 0) {
//                    queue.offer(v);
//                }
//            }
//        }
//
//        if (count == numCourses) return res;
//        else return new int[0];
//    }
//}



class Solution {

    Deque<Integer> stack = new ArrayDeque<>();

    List<List<Integer>> edges = new ArrayList<>();

    boolean flag;

    int[] visited;

    List<Integer> res = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (flag) {
            return new int[0];
        }
        int[] res = new int[numCourses];
        int count = 0;
        while (!stack.isEmpty()) {
            res[count++] = stack.pop();
        }
        return res;

    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int vertex : edges.get(u)) {
            if (visited[vertex] == 0) {
                dfs(vertex);
                if (flag) return;
            } else if (visited[vertex] == 1) {
                flag = true;
                return;
            }
        }
        visited[u] = 2;
        stack.push(u);
    }
}