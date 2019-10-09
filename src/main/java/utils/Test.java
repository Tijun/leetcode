package utils;

import datastructs.TreeNode;

public class Test {

    public static void main(String[] args) {
        Integer [] nums = new Integer[]{1,2,null,null,3,null,4};
        TreeNode root = Arr2TreeNode.buildByNumberArr(nums);
        System.out.println(root);
    }
}
