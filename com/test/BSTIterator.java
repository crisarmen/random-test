package com.test;

import java.util.Stack;

/**
 * Created by carmentano on 26/07/2018.
 */
public class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        insertAllLeftKids(root);
    }

    private void insertAllLeftKids(TreeNode n){
        while(n != null) {
            stack.push(n);
            n = n.left;
        }
    }


    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        //TODO exception if empty?
        TreeNode nextNode = stack.pop();
        insertAllLeftKids(nextNode.right);
        return nextNode.val;
    }
}
