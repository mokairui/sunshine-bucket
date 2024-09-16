package com.sunshine.动态规划不同子序列;

/**
 * @author Mokairui
 * @description 动态规划解不同的子序列
 *  给定一个字符串s和一个字符串t，计算在s的子序列中t出现的个数。
 *  字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置
 *  所组成的新字符串。（例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
 *  题目数据保证答案符合32位带符号整数范围
 *  
 *  输入：s = "ra b b b i t", t = "ra b b i t"
 *  输出：3
 *  解释：
 *  如下图所示, 有3种可以从s中得到"ra b b i t"的方案。
 *  ra b bbi t
 *  ra bbb i t
 *  rabb b i t
 * @since 2024/8/24
 */
public class Application {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(numDistinct(s, t));
    }

    public static int numDistinct(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        int[][] dp = new int[tLength + 1][sLength + 1];
        
        // 因为空字符串" "是所有字符串的子集，所以设置边界条件
        for (int j = 0; j <= sLength; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i <= tLength; i++) {
            for (int j = 1; j <= sLength; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[tLength][sLength];
    }
}
