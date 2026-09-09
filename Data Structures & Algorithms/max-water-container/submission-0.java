class Solution {
    public int maxArea(int[] h) {
        int n= h.length;
        int left =0;
        int right = n-1;
        int ans = 0;
        while(left<right) {
            ans = Math.max(ans, Math.min(h[left],h[right]) * (right-left));
            if(h[left]>h[right]) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
        
    }
}
