class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        value_dict = {}
        for i in range(len(nums)):
            x = target - nums[i]
            if x in value_dict:
                return [value_dict[x], i]
            else:
                value_dict[nums[i]] = i

        
        return None
        