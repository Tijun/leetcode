package leetcode;

import datastructs.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        private Map<Integer, Integer> inorderValuePositionMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0){
                return null;
            }
            inorderValuePositionMap = buildVal2PositionMap(inorder);
            TreeNode root = new TreeNode(preorder[0]);
            return dfs(int2IntegerList(preorder),int2IntegerList(inorder));
        }


        private TreeNode dfs(List<Integer> preorder, List<Integer> inorder){
           TreeNode node = new TreeNode(preorder.get(0));
           int inPosition = inorderValuePositionMap.get(node.val);
           if (inPosition - 1 > 0){// 左子树为null
                node.left = dfs(preorder.subList(1,preorder.size()),inorder.subList(0,inPosition -1));
           }
           if (inPosition + 1 < inorder.size()){
               node.right = dfs(preorder.subList(2,preorder.size()),inorder.subList(inPosition + 1,inorder.size()));
           }

           return node;


        }
        private List<Integer> int2IntegerList(int [] ints){
            List<Integer> list = new ArrayList<Integer>(ints.length);
            for (int i = 0; i < ints.length;i++){
                list.add(Integer.valueOf(ints[i]));
            }
            return list;
        }
        private Map<Integer,Integer> buildVal2PositionMap(int[] inorder){
            Map<Integer,Integer> val2PositionMap = new HashMap<Integer, Integer>();
            for (int i = 0 ; i < inorder.length; i ++){
                val2PositionMap.put(inorder[i],i);
            }
            return val2PositionMap;
        }
    }
}
