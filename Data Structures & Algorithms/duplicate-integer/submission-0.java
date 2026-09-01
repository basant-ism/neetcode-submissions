class Solution {
    public boolean hasDuplicate(int[] nums) {
    
        return nums.length!=Arrays.stream(nums).boxed().collect(Collectors.toSet()).size();
        
    }
}