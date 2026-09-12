class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int max = 0;
        for(int i=1;i<n;i++) {
            max = Math.max(max, h[i-1]);
            leftMax[i] = max;
        }

        max = 0;
        for(int i=n-2;i>=0;i--) {
            max = Math.max(max, h[i+1]);
            rightMax[i] = max;
        }
        int ans=0;
        for(int i=0;i<n;i++) {
            ans= ans + Math.max(0,Math.min(leftMax[i],rightMax[i]) - h[i]);
        }

        return ans;
    }
    /*
    6
    4
    5
    i=7
    2 0 1
    */
}
