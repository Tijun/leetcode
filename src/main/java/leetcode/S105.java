package leetcode;

import datastructs.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class S105 {

    public static void main(String[] args) {

    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0){
                return null;
            }
            int midPosition = 0;
            TreeNode root = new TreeNode(preorder[0]);
            while (midPosition < preorder.length){


            }
            return root;
        }
    }
}
