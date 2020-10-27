class Solution {
    public int myAtoi(String str) {
        
        if(str.length() == 0) return 0;
        
        // remove whitespaces
        int i = 0;
        while(i < str.length() && str.charAt(i) == ' ') i++;
        str = str.substring(i, str.length());
        
        if(str.length() == 0) return 0;

        int sign = 1;
        char firstChar = str.charAt(0);
        if(firstChar == '-' || firstChar == '+') {
            sign = (firstChar == '-')? -1: 1;
            str = str.substring(1, str.length());
        }
        
        long result = 0;
        
        for(i=0; i<str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9'); i++ ) {
            if(result > (long)Integer.MAX_VALUE) {
               return (sign == -1)? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
            
            result = result*10 + (long)(str.charAt(i) - '0');
        }
        if(result > (long)Integer.MAX_VALUE) {
                return (sign == -1)? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }
        
        return sign*(int)result;
    }
}