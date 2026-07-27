class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;//
            int ptr1 = i;
            int ptr2 = nums.length - 1;
            while (ptr1 < ptr2){
                if (ptr1 == i) ptr1++;
                if (ptr2 == i) ptr2--;
                if (ptr1 == ptr2) break;
                int sum = -(nums[ptr1] + nums[ptr2]);
                if (sum == nums[i]){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[ptr1]);
                    arr.add(nums[ptr2]);
                    result.add(arr);
                    while (ptr1 < ptr2 && nums[ptr1] == nums[ptr1 + 1]) ptr1++;
                    while (ptr1 < ptr2 && nums[ptr2] == nums[ptr2 - 1]) ptr2--;
                    ptr1++;
                    //ptr2--;
                } else if (sum > nums[i]){
                    ptr1++;
                } else {
                    ptr2--;
                }
            }
        }
        return result;
    }
}
// [-4,-1,-1,0,1,2]
//nums[i] = -(nums[j] + nums[k])