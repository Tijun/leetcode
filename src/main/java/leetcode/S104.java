package leetcode;

import datastructs.TreeNode;
import utils.TreeNodeBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class S104 {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNodeBuilder.buildByNumberArr(arr);
        int dfs = new S104().new Solution().maxDepth(root);
        System.out.println(dfs);
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            return bfs(root);
        }
        private int bfs(TreeNode root){
            if (root == null){
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            int depth = 0;
            while (queue.size() != 0){// 未遍历完成
                int n = queue.size();
                depth++;
                while (n > 0){ // 一个层级的节点数量
                    TreeNode remove = queue.remove();
                    if (remove.left != null){
                        queue.add(remove.left);
                    }
                    if (remove.right != null){
                        queue.add(remove.right);
                    }
                    n --;
                }
            }
            return depth;
        }
    }
}
