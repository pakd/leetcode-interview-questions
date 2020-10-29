class Solution {
    
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0) return "";

        boolean[][] dp = new boolean[len][len];

        int maxLength = 1;
        String ans = "" + s.charAt(0);

        // base conditions
        for(int i=0; i<len; i++)
        {
            dp[i][i] = true; // substring with one character is always palindrome
        }

        // substrings of length 2
        for(int i=0; i<len-1; i++) {
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1))? true: false;
            if(dp[i][i+1]) {
                maxLength = 2;
                ans = s.substring(i, i+2);
            }
        }

        for(int windowsSize = 3; windowsSize<=len; windowsSize++) {
            for(int i=0; i<=len-windowsSize; i++) {

                int j = i + windowsSize - 1;

                dp[i][j] = (s.charAt(i) == s.charAt(j))? dp[i+1][j-1]: false;
                if(dp[i][j]) {
                    maxLength = windowsSize;
                    ans = s.substring(i, j+1);
                }
            }
        }

        return ans;
    }
}