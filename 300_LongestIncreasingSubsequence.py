class Solution:
    def lengthOfLIS(self, nums):
        result = [1] * (len(nums))
        for i in range(len(nums)):
            for j in range(i):
                if nums[j] < nums[i]:
                    result[i] = max(result[i], result[j] + 1)

        return max(result)


solution = Solution()
print(solution.lengthOfLIS([10,9,2,5,3,7,101,18])) #4


                
                
