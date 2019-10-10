package leetcode;

import datastructs.TreeNode;
import utils.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S103 {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNodeBuilder.buildByNumberArr(arr);
        List<List<Integer>> lists = new S103().new Solution().zigzagLevelOrder(treeNode);
        System.out.println(lists);
    }
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> levels = new ArrayList<List<Integer>>();
            if (root == null){
                return levels;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            Queue<TreeNode> temp = new LinkedList<TreeNode>();
            List<Integer> nums = new ArrayList<Integer>();
            while (queue.size() != 0){
                TreeNode remove = queue.remove();
                nums.add(remove.val);
                if (remove.left != null){
                    temp.offer(remove.left);
                }
                if (remove.right != null){
                    temp.offer(remove.right);
                }
                if (queue.size() == 0){
                    queue.addAll(temp);
                    temp.clear();
                    levels.add(nums);
                    nums = new ArrayList<Integer>();
                }
            }
            return levels;
        }
    }
}
