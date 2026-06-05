package com.lullaby.dp.lc95;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> allTree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            allTree.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                for (TreeNode left : allTree.get(j - 1)) {
                    for (TreeNode right : allTree.get(i - j)) {
                        allTree.get(i).add(new TreeNode(i, left, right));
                    }
                }
            }
        }

        return allTree.get(n);
    }
}


