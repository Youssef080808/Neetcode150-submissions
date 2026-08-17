class Solution {
    public int findMin(int[] nums) {
        int high = nums.length-1;
        int low = 0;
        while (low < high){
            int mid = (high+low)/2;            
            if (nums[mid] > nums[high]){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}//[3,4,5,6,1,2],h=,l=,min=3
//[6,1,2,3,4,5]