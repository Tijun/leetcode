package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S18 {

    public static void main(String[] args) {
        int[] ints = {0, 0, 0};
        new S18().new Solution().threeSum(ints);
    }
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            Arrays.sort(nums);
            for (int i=nums.length - 1; i>=2; i--){
                int pre = 0;
                int end = i - 1;
                int expect = - nums[i];
                while (pre < end){
                    int sum = nums[pre] + nums[end];
                    if (expect == sum){
                        result.add(Arrays.asList(nums[pre],nums[end],nums[i]));
                        while (nums[pre] == nums[pre + 1] && pre < end){
                            pre ++;
                        }
                        while (nums[end] == nums[end - 1] && pre < end){
                            end --;
                        }
                    }
                    if (sum > expect){
                        end --;
                    }else {
                        pre ++;
                    }
                }
                if (i >0 && nums[i-1]==nums[i]){
                    i--;
                }
            }
            return result;
        }
    }

}
