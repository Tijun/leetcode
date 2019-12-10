package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S3 {
    public static void main(String[] args) {
        String s = "dvdf";
        new S3().new Solution().lengthOfLongestSubstring(s);
    }
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> current = new HashSet<>();
            int result = 0;
            for (int i = 0; i < s.length(); i++){
                if (current.contains(s.charAt(i))){// 包含
                    current.clear();
                    current.add(s.charAt(i));
                }else {
                    current.add(s.charAt(i));
                }
                result = current.size() > result ? current.size():result;
            }
            return result;
        }
    }

}
