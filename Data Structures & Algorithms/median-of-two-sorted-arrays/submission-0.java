class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ptr1 = 0;
        int ptr2 = 0;
        int total = nums1.length + nums2.length;
        boolean isEven = (total%2 == 0);
        int prev = -1;
        int cur = -1;
        for (int i = 0; i <= total/2; i++){
            prev = cur;
            if (ptr1 >= nums1.length){
                cur = nums2[ptr2++];
            } else if (ptr2 >= nums2.length) {
                cur = nums1[ptr1++];
            } else if (nums1[ptr1] <= nums2[ptr2]){
                cur = nums1[ptr1++];
            } else {
                cur = nums2[ptr2++];
            }
        }
        double ans;
        if (isEven){
            ans = (double) (cur+prev)/2;
        } else {
            ans = cur;
        }
        return ans; 
    }
}
