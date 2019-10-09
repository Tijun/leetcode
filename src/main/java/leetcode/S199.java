package leetcode;

import datastructs.TreeNode;
import utils.Arr2TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S199 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,null,5,null,4};
        TreeNode treeNode = Arr2TreeNode.buildByNumberArr(arr);
        System.out.println(new S199().new Solution().rightSideView(treeNode));
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            return bfs(root);
            //return dfs(root,0,new ArrayList<Integer>());
        }

        private List<Integer> bfs(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if (root == null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
            result.add(root.val);
            while (queue.size() != 0){
                TreeNode remove = queue.remove();
                if (remove.left != null){
                    temp.offer(remove.left);
                }
                if (remove.right != null){
                    temp.offer(remove.right);
                }
                if (queue.size() == 0){
                    queue.addAll(temp);
                    if (!temp.isEmpty()){
                        result.add(temp.getLast().val);
                    }
                    temp.clear();
                }
            }
            return result;
        }

        public List<Integer> dfs(TreeNode root,int depth,List<Integer> result){
            if (root == null){
                return result;
            }
            if (depth == result.size()){
                result.add(root.val);
            }
            depth ++ ;
            dfs(root.right,depth,result);
            dfs(root.left,depth,result);
            return result;
        }
    }
}
