class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer>mp = new HashMap<>();
        for(int i=0;i<n;i++){
            int temp = target-nums[i];
            if(mp.containsKey(temp)) return new int[]{mp.get(temp),i};
            mp.put(nums[i],i);
        }
        return new int[]{-1};
    }
}
