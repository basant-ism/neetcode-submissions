class Solution {

     public Set<List<Integer>> twoSum(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;
        Set<List<Integer>> set = new HashSet<>();
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum < target) left++;
            else if(sum > target) right--;
            else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                set.add(list);
                left++;
                right--;
            }

        }
        return set;

    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            Set<List<Integer>> set = twoSum(nums, i+1, -nums[i]);
            
            for(List<Integer> list: set){
                list.add(0,nums[i]);
                ans.add(list);
            }
            
        }
        return new ArrayList<>(ans);
        
    }
}
