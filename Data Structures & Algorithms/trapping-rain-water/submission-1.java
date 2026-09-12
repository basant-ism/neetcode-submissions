class Solution {
    public int trap(int[] h) {
        int n = h.length;
        // int[] leftMax = new int[n];
        // int[] rightMax = new int[n];
        // int max = 0;
        // for(int i=1;i<n;i++) {
        //     max = Math.max(max, h[i-1]);
        //     leftMax[i] = max;
        // }

        // max = 0;
        // for(int i=n-2;i>=0;i--) {
        //     max = Math.max(max, h[i+1]);
        //     rightMax[i] = max;
        // }
        // int ans=0;
        // for(int i=0;i<n;i++) {
        //     ans= ans + Math.max(0,Math.min(leftMax[i],rightMax[i]) - h[i]);
        // }

        // return ans;



        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while(left < right) {
            if(h[left] < h[right]) {
                if(h[left] > leftMax) {
                    leftMax = h[left];
                } else {
                    water += leftMax - h[left];
                }
                left++;
            } else {
                if(h[right] > rightMax) {
                    rightMax = h[right];
                } else {
                    water += rightMax - h[right];
                }
                right--;
            }
        }
        return water;
    }
    /*
    6
    4
    5
    i=7
    2 0 1
    */
}
