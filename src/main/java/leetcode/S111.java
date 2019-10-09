package leetcode;

import datastructs.TreeNode;
import utils.Arr2TreeNode;

public class S111 {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = Arr2TreeNode.buildByNumberArr(arr);
        int dfs = new S111().new Solution().minDepth(root);
        System.out.println(dfs);
    }

    class Solution {
        public int minDepth(TreeNode root) {
            return dfs(root,Double.POSITIVE_INFINITY,0);
        }

        private int dfs(TreeNode root,Double min,int current){

            if (root == null && min != Double.POSITIVE_INFINITY){
                return min.intValue();
            }
            if (root == null && min == Double.POSITIVE_INFINITY){
                return 0;
            }
            if (root.right == null && root.left == null){
                min = min.intValue() > current ? current : min;
            }
            current ++;
            int m1 = dfs(root.left,min,current);
            int m2 = dfs(root.right,min,current);
            return m1 > m2 ? m2:m1;
        }
    }
}
