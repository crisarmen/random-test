package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NextInInorderVisit {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorderSuccessorAux(root, p).val;
    }

    ResultAux inorderSuccessorAux(TreeNode root, TreeNode p) {
        ResultAux resultAux = null;
        if(root == null) {
            resultAux = new ResultAux(false, null);
        } else {
            ResultAux leftResult = inorderSuccessorAux(root.left, p);
            if(leftResult.val != null) {
                resultAux = leftResult;
            } else if(leftResult.found) {
                resultAux = new ResultAux(true, root);
            } else {
                if(root == p) {
                    return findLeftMost(root.right);
                } else {
                    resultAux = inorderSuccessorAux(root.right, p);
                }
            }
        }

        return resultAux;
    }

    ResultAux findLeftMost(TreeNode root) {
        if(root == null) {
            return new ResultAux(true, null);
        } else if(root.left != null) {
            return findLeftMost(root.left);
        } else {
            return new ResultAux(true, root);
        }
    }

    static class ResultAux {
        boolean found;
        TreeNode val;

        ResultAux(boolean found, TreeNode val) {
            this.val = val;
            this.found = found;
        }
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            List<List<Integer>> result = new ArrayList<>();
            levelOrderAux(root, 0, map);
            for(int i = 0; i < map.size(); i++) {
                result.add(map.get(i));
            }
            return result;
        }

        void levelOrderAux(TreeNode root, int level, Map<Integer, List<Integer>>  levelMaps) {
            if(root != null) {
                List<Integer> currentLevelList = levelMaps.computeIfAbsent(level, k -> new ArrayList<>());
                currentLevelList.add(root.val);

                levelOrderAux(root.left, level + 1, levelMaps);
                levelOrderAux(root.right, level + 1, levelMaps);
            }
        }
    }

}
