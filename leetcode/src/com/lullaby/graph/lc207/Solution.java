package com.lullaby.graph.lc207;

import java.util.*;

//class Solution {
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[] degree= new int[numCourses];
//        for (int i = 0; i < prerequisites.length; i++) {
//            degree[prerequisites[i][0]]++;
//        }
//
//        Deque<Integer> stack = new ArrayDeque<>();
//        boolean[] mark = new boolean[numCourses];
//        for (int i = 0; i < degree.length; i++) {
//            if (degree[i] == 0) {
//                stack.push(i);
//                mark[i] = true;
//            }
//        }
//
//        while (!stack.isEmpty()) {
//            int num = stack.pop();
//            for (int i = 0; i < prerequisites.length; i++) {
//                if (!mark[prerequisites[i][0]] && prerequisites[i][1] == num) {
//                    degree[prerequisites[i][0]]--;
//                    if (degree[prerequisites[i][0]] == 0) {
//                        stack.push(prerequisites[i][0]);
//                        mark[prerequisites[i][0]] = true;
//                    }
//                }
//            }
//        }
//
//        for (boolean flag : mark) {
//            if (!flag) return false;
//        }
//
//        return true;
//    }
//}



//class Solution {
//
//    int[] degree;
//    List<List<Integer>> edge = new ArrayList<>();
//
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        for (int i = 0; i < numCourses; i++) {
//            edge.add(new ArrayList<>());
//        }
//
//        degree = new int[numCourses];
//        for (int[] info : prerequisites) {
//            // 出度邻接表
//            edge.get(info[1]).add(info[0]);
//            degree[info[0]]++;
//        }
//
//        int visited = 0;
//        Deque<Integer> queue = new ArrayDeque<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (degree[i] == 0) {
//                queue.offer(i);
//                visited++;
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int num = queue.poll();
//            for (int vertex : edge.get(num)) {
//                if (--degree[vertex] == 0) {
//                    queue.offer(vertex);
//                    visited++;
//                }
//            }
//        }
//
//        if (visited == numCourses) return true;
//        else return false;
//    }
//}



class Solution {

    int[] visited;

    List<List<Integer>> edges = new ArrayList<>();

    boolean flag;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        // 出度邻接表
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        visited = new int[numCourses];
        flag = true;

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        return flag;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!flag) return;
            } else if (visited[v] == 1){
                flag = false;
                return;
            }
        }

        visited[u] = 2;
    }
}