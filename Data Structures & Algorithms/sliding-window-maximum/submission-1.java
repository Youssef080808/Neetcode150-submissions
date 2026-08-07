class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        while (right < nums.length){//[1,2,1,0,4,2,6],22,l=1,r=4,011
            if (right < k){
                maxHeap.add(nums[right]);
                map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
                right++;
            } else {
                while (map.getOrDefault(maxHeap.peek(), 0) == 0){
                    maxHeap.poll();
                }
                arr[left] = maxHeap.peek();
                map.put(nums[left], map.get(nums[left]) - 1);
                maxHeap.add(nums[right]);
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                left++;
                right++;
            }
        }
        while (map.getOrDefault(maxHeap.peek(), 0) == 0) {  // NEW
            maxHeap.poll();
        }
        arr[left] = maxHeap.peek();
        return arr; 
    }
}
//[1,3,1,0,2,2,6]