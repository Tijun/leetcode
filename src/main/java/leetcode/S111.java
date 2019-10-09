package leetcode;

import datastructs.TreeNode;
import utils.Arr2TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class S111 {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = Arr2TreeNode.buildByNumberArr(arr);
        int dfs = new S111().new Solution().minDepth(root);
        System.out.println(dfs);
    }

    class Solution {
        public int minDepth(TreeNode root) {
            return bfs(root);
            // todo 给出递归解法
        }

        private int bfs(TreeNode root){
            int depth = 0;
            if (root == null){
                return depth;
            }
            depth ++;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            Queue<TreeNode> temp = new LinkedList<TreeNode>(); //todo 可以优化通过size优化此空间
            while (queue.size() != 0){
                TreeNode remove = queue.remove();
                if (remove.left == null && remove.right == null){
                    return depth;
                }
                if (remove.left != null){
                    temp.add(remove.left);
                }
                if (remove.right != null){
                    temp.add(remove.right);
                }
                if (queue.size() == 0 && temp.size() != 0){
                    depth ++;
                    queue.addAll(temp);
                    temp.clear();
                }
            }
            return depth;

        }
    }
}
