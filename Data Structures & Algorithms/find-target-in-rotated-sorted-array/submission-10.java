class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high){ 
            int mid = (high+low+1)/2;
            if (nums[mid] == target) return mid;
            if (nums[low] < nums[mid]){
                if (target < nums[mid] && target >= nums[low]){
                    if (target == nums[low]) return low;
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]){
                    if (target == nums[high]) return high;
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}