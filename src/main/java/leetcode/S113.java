package leetcode;

import datastructs.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class S113 {


    class Solution {
        private LinkedList<Integer> record = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            return noneRec(root,sum);
        }
        private void dfs(TreeNode root,int sum){
            if (root == null){
                return;
            }
            int remain = sum - root.val;
            record.addLast(root.val);
            if (root.left == null && root.right == null && remain == 0){
                List<Integer> dist = new ArrayList<>(record.size());
               dist.addAll(record);
                result.add(dist);
            }
            if (root.left != null) {
                dfs(root.left,remain);
            }
            if (root.right != null) {
                dfs(root.right,remain);
            }
            record.removeLast();
        }
        private List<List<Integer>> noneRec(TreeNode  root,int sum){
            List<List<Integer>> results = new ArrayList<>();
             LinkedList<TreeNode> stack = new LinkedList<>();
             stack.addLast(root);
             int tempNum = root.val;
             while (!stack.isEmpty()){
                 TreeNode lastNode = stack.peekLast();
                 // todo 判断什么时候弹出节点
                 while (lastNode.left != null){
                     stack.addLast(lastNode.left);
                     lastNode = lastNode.left;
                     tempNum += lastNode.left.val;
                 }
                 if (lastNode.right != null){
                     stack.addLast(lastNode.right);
                     tempNum += lastNode.right.val;
                 }else if (tempNum == sum){
                     // 这种情况是左节点，右节点为null
                     List<Integer> collect = stack.stream().map(r -> r.val).collect(Collectors.toList());
                     results.add(collect);
                 }else {
                     tempNum -= lastNode.val;
                     stack.removeLast();
                 }

             }
             return results;
        }

    }

}
