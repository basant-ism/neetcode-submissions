class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) 
            return findMedianSortedArrays(nums2, nums1);
        int left = 0;
        int right = m;
        int total = n + m;

        while(left <= right) {
            int cut = left + (right - left)/2;
            int cut2 = (total + 1) / 2 - cut;

            int left1 = cut == 0 ? Integer.MIN_VALUE : nums1[cut-1];
            int right1 = cut == m ? Integer.MAX_VALUE : nums1[cut];

            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int right2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];

            if(left1 <= right2 && left2 <= right1) {
                //correct partition
                if(total % 2 == 1){
                    //odd ele
                    return Math.max(left1, left2);
                } else {
                    return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                }
            }

            if(left1 > right2) {
                right = cut - 1;
            } else {
                left = cut + 1;
            }
        }
        return 0;
        
    }
}
