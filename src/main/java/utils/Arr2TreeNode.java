package utils;

import datastructs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Arr2TreeNode {

    public static TreeNode buildByNumberArr(Integer[] numbers){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(numbers[0]);
        queue.add(root);
        int count = 0;
        for (int i = 1;i < numbers.length; i+=2 ){
            TreeNode head = queue.remove();
            if (numbers[i] != null){
                TreeNode left = new TreeNode(numbers[i]);
                queue.add(left);
                head.left = left;
            }
            if (i + 1 < numbers.length && numbers[i+1] != null){
                TreeNode right = new TreeNode(numbers[i+1]);
                queue.add(right);
                head.right = right;
            }
        }
        return root;
    }

}
