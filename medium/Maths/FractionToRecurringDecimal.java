class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // edge case
        if(numerator == 0) return "0";
        
        StringBuilder ans = new StringBuilder();
                
        // append sign using xor operation
        ans.append( ( (numerator>0) ^ (denominator>0) ) ? "-": "");

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        long remainder = num%den;
        ans.append(num / den);
        
        if(remainder == 0) return ans.toString();
        
        ans.append(".");
        
        //////////////////////logic for fraction ///////////////////////////////
        
        Map<Long, Integer> map = new HashMap();
        StringBuilder fraction = new StringBuilder();
        
        //for putting "."
        remainder = (remainder%den)*10;
        
        while(remainder != 0) {
            if(map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                ans.append(fraction.toString());
                return ans.toString();
            }
            
            map.put(remainder, fraction.length());
            fraction.append(remainder/den);
            remainder = (remainder%den)*10; 
        }
        
        ans.append(fraction.toString());
        return ans.toString();  
    }
}