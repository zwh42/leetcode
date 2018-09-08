class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        answer = []
        nums.sort()
        for i in range(len(nums) - 2):
            if i > 0 and nums[i-1] == nums[i]: continue
            if i == 0 or nums[i] > nums[i - 1]:
                left, right = i + 1, len(nums) - 1
                while left < right:
                    if nums[left] + nums[right] + nums[i] == 0:
                        answer.append([nums[i], nums[left], nums[right]])
                        left += 1
                        right -= 1
                        while left < right and nums[left] == nums[left - 1]:
                            left += 1
                        while left < right and nums[right] == nums[right + 1]:
                            right -= 1
                    elif nums[left] + nums[right] + nums[i] < 0:
                        
                            left += 1
                            
                    else: #nums[left] + nums[right] + nums[i] > 0:
                       
                            right -= 1
                            
                        
        return answer

solution = Solution()
print(solution.threeSum([-1,0,1,2,-1,-4]))
                