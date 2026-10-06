class Solution {
    
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
       int left = 0;
       int[] freq = new int[26];
       for(int i=0;i<s1.length();i++) {
            freq[s1.charAt(i)-'a']++;
       }
       int windowSize = s1.length();
       for(int right = 0; right < s2.length(); right++) {
            //add
            freq[s2.charAt(right)-'a']--;
            if(right >= windowSize) {
                freq[s2.charAt(right - windowSize)-'a']++;
            }
            if(right>=windowSize-1 && isZero(freq)) {
                return true;
            }
       }
       return false;
        
    }
    boolean isZero(int[] freq){
        for(int i=0;i<26;i++) {
            if(freq[i]!=0) return false;
        }
        return true;
    }
}
