package com.test;

/**
 * Created by carmentano on 03/07/2018.
 */
public class FlatTree {

    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        flattenAux(root);
    }

    private TreeNode flattenAux(TreeNode n) {
        if(n == null) {
            return null;
        } else if(n.left == null && n.right == null) {
            return n;
        } else {
            TreeNode lFlat = flattenAux(n.left);
            TreeNode rFlat = flattenAux(n.right);

            if(lFlat != null) {
                TreeNode oldRightNode = n.right;
                n.right = n.left;
                n.left = null;
                lFlat.right = oldRightNode;
            }

            if(rFlat != null) {
                return rFlat;
            } else if(lFlat != null) {
                return lFlat;
            } else {
                return n;
            }
            //[1,2,5,7,3,4,null,6]
        }
    }
}
