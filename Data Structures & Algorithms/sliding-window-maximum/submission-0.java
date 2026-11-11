class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left =0;
        int right = k-1;
        int n=nums.length;
        int mxIndex=0;
        for(int i=1;i<k;i++) {
            if(nums[i]>=nums[mxIndex]) {
                mxIndex = i;
            }
        }
        int[] ans = new int[n-k+1];
        ans[0] = nums[mxIndex];
        for(int i=k;i<n;i++) {
            if(mxIndex != (i-k)) {
                 if(nums[i]>=nums[mxIndex]) {
                    mxIndex = i;
                }
            } else {
                for(int j=mxIndex+1;j<=i;j++) {
                     if(nums[j]>=nums[mxIndex]) {
                        mxIndex = j;
                    }
                }
            }
            ans[i-k+1] = nums[mxIndex];
        }
        
        return ans;
    }
}
