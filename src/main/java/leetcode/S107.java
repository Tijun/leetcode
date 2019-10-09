package leetcode;

import datastructs.TreeNode;
import utils.Arr2TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S107 {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        TreeNode treeNode = Arr2TreeNode.buildByNumberArr(arr);
        System.out.println(new S107().new Solution().levelOrderBottom(treeNode));
    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            LinkedList<List<Integer>> levels = new LinkedList<List<Integer>>();
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
                    levels.addFirst(nums);
                    nums = new ArrayList<Integer>();
                }
            }
            return levels;
        }

    }
}
