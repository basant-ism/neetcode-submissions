class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum < target) left++;
            else if(sum > target) right--;
            else {
                int[] ans = new int[2];
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            }

        }
        return new int[2];

    }
}
