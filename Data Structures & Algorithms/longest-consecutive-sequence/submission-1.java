class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        int currMax = 1;
        int ans=1;
        if(n==0) return 0;
        int prev = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]==prev) continue;

            if(prev+1==nums[i]) {
                currMax++;
                prev=nums[i];
            }
            else {
                ans = Math.max(currMax,ans);
                currMax=1;
                prev=nums[i];
            }

        }
        ans = Math.max(currMax,ans);

        return ans;
        
    }
    //0 1 1 3
}
