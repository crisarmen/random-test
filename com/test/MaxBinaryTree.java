package com.test;

/**
 * Created by carmentano on 24/07/2018.
 */
public class MaxBinaryTree {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        } else if(start == end) {
            return new TreeNode(nums[start]);
        } else {
            int posMax = start;
            for(int i = start + 1; i <= end; i++) {
                if (nums[i] > nums[posMax]){
                    posMax = i;
                }
            }

            TreeNode r = new TreeNode(nums[posMax]);
            r.left = constructMaximumBinaryTree(nums, start, posMax - 1);
            r.right = constructMaximumBinaryTree(nums, posMax + 1, end);

            return r;
        }
    }

    // closest value
    public int closestValue(TreeNode root, double target) {
        if(root == null) {
            return 0;
        } else {
            return closestValue(root, target, root.val);
        }
    }

    private int closestValue(TreeNode root, double target, int currentClosest) {
        if(root == null) {
            return currentClosest;
        } else {
            double delta = Math.abs(root.val - target);
            if(delta < 0.5) {
                return root.val;
            } else {
                if(delta < Math.abs(target-currentClosest)) {
                    currentClosest = root.val;
                }
                if(root.val > target) {
                    return closestValue(root.right, target, currentClosest);
                } else {
                    return closestValue(root.left, target, currentClosest);
                }
            }
        }
    }

    //// subtree
    public boolean isSubtree(TreeNode s, TreeNode t) {
        TreeNodePlus sPlus = buildTreeNodePlus(s);
        int subtreeHeight = treeHight(t);

        return isSubtree(sPlus, t, subtreeHeight);
    }

    private boolean isSubtree(TreeNodePlus s, TreeNode t, int tHeight) {
          if(s == null) {
              return t == null;
          } else {
              if(s.height > tHeight) {
                  return (s.left != null && isSubtree(s.left, t, tHeight)) ||
                      (s.right != null && isSubtree(s.right, t, tHeight));
              } else {
                  return compareTrees(s,t);
              }
          }
    }

    private boolean compareTrees(TreeNodePlus s, TreeNode t) {
          if(s == null) {
              return t == null;
          } else {
              if(t == null) {
                  return false;
              } else {
                  return s.val == t.val && compareTrees(s.left, t.left) && compareTrees(s.right, t.right);
              }
          }
    }

    private int treeHight(TreeNode t) {
          if(t == null) {
              return 0;
          } else {
              return 1 + Math.max(treeHight(t.left), treeHight(t.right));
          }
    }

    private TreeNodePlus buildTreeNodePlus(TreeNode t) {
        if(t == null) {
            return null;
        } else {
            TreeNodePlus left = buildTreeNodePlus(t.left);
            TreeNodePlus right = buildTreeNodePlus(t.right);
            int newHeight = Math.max((left == null ? 0 : left.height), (right == null ? 0 : right.height)) + 1;
            return new TreeNodePlus(t.val, newHeight, left, right);
        }
    }

    static class TreeNodePlus {
        int val;
        int height;
        TreeNodePlus left;
        TreeNodePlus right;

        TreeNodePlus(int val, int height, TreeNodePlus left, TreeNodePlus right) {
            this.val = val;
            this.height = height;
            this.right = right;
            this.left = left;
        }
    }

}
