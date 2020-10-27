class Solution {
    int prime = 101;
    
    public long calculateHash(char[] str, int start, int end) {
        long hash = 0;
        for(int i=start; i<=end; i++ ) {
            hash += str[i]*Math.pow(prime, (i - start));
        }
        return hash;
    }
    
    public long recalculateHash(char[] str, long oldHash, int oldStart, int oldEnd) {
        int len = oldEnd - oldStart + 1;
        long newHash = oldHash;
        newHash -= str[oldStart];
        newHash /= prime;
        newHash += (long)str[oldEnd+1]*Math.pow(prime, len-1);
        return newHash;
    }
    
    public boolean isEqual(char[] str1, int start1, int end1, char[] str2, int start2, int end2) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        int i = start1,j = start2;
        if(len1 != len2) return false;
        while(i <= end1) {
            if(str1[i] != str2[j]) return false;
            i++;
            j++;
        }
        return true;
    }
    
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        // sanity checks
        if(n < m) return -1;
        if(m == 0) return 0;
        
        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        
        long patternHash = calculateHash(pattern, 0, m - 1);
        long textHash = calculateHash(text, 0, m - 1);
        
        for(int i=1; i<=n-m+1; i++) {
            if(patternHash == textHash && isEqual(text, i-1, i+m-2, pattern, 0, m-1)) {
                return i-1;
            }
            if(i < n-m+1) {
                textHash = recalculateHash(text, textHash, i-1, i+m-2);
            }
        }
        
        return -1;
    }   
}