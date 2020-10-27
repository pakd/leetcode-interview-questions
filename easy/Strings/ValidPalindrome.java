import java.lang.*;
class Solution {
    
    public boolean isPalindromeUtil(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length-1;
        
        while(i < j) {
            if(arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public boolean isAlphaNumeric(char ch) {
        if ( 
            (ch >= '0' && ch <= '9') || 
            (ch >= 'a' && ch <= 'z') || 
            (ch >= 'A' && ch <= 'Z') ) {
            return true;
        }
        return false;
    }
    
    public boolean isSmall(char ch) {
        if(ch >= 'a' && ch <= 'z') {
            return true;
        }  
        return false;
    }
    
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        int n = s.length();
        for(int i=0; i<n; i++) {
            char t = s.charAt(i);
            if(isAlphaNumeric(t)) {
                if(isSmall(t)) {
                    char temp = (char)(t - 32);
                    sb.append(temp);
                } else {
                    sb.append(t);    
                }
            }
        }
        
        return isPalindromeUtil(sb.toString());
    }
}