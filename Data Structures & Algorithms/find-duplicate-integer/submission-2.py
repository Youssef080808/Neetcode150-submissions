class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # Need to memorise way but very simple

        single = 0
        double = 0
        while True:
            single = nums[single]
            double = nums[nums[double]]
            if single == double:
                break

        single = 0
        while True:
            single = nums[single]
            double = nums[double]
            if single == double:
                return single