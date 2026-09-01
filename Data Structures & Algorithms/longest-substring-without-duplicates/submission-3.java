class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n=s.length();
        int maxLen = 0;
        int start = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                
                int temp = map.get(ch) + 1;
                if(temp>start) start= temp;

                
            }
            
            maxLen = Math.max(maxLen,i-start+1);
            //System.out.println("i " + i + "start " + start + "maxLen " + maxLen);
            map.put(ch,i);
        }
        return maxLen;
    }
}
