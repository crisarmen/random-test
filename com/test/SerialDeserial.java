package com.test;

public class SerialDeserial {

    public static void main(String[] args) {
        TreeNode n = new TreeNode(2);
        n.left = new TreeNode(1);
        n.right = new TreeNode(3);

        String serialize = new SerialDeserial().serialize(n);
        TreeNode deserialize = new SerialDeserial().deserialize(serialize);
        int a = 1;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private void inOrder(TreeNode n, StringBuilder sb) {
        if(n == null) {
            sb.append(",");
        } else {
            sb.append(n.val).append(",");
            inOrder(n.left, sb);
            inOrder(n.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",", -1);        //contains one more element
        int[] idx = new int[1];
        idx[0] = 0;
        return build(vals, idx);
    }

    private TreeNode build(String[] vals, int[] idx) {
        if(vals.length == 1 || vals[idx[0]].equals("")) {
            idx[0]++;
            return null;
        } else {
            TreeNode n = new TreeNode(Integer.valueOf(vals[idx[0]]));
            idx[0]++;
            n.left = build(vals, idx);
            n.right = build(vals, idx);
            return n;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
