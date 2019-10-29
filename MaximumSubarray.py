## Python3

class Solution:
    def maxSubArray(self, nums):
        return self._maxSubArray(nums, 0, len(nums))
    
    
    def _maxSubArray(self, nums, lo, hi):
        if (hi - lo) <= 1:
            return nums[lo]
        
        mid = (lo + hi) // 2
        #print("lo = {}, mid = {}, hi = {}".format(lo, mid, hi))
        #print("max left: {}".format(self._maxSubArray(nums, lo, mid)))
        #print("max right: {}".format(self._maxSubArray(nums, mid, hi)))
        #print("center: {}".format(self._maxCrossArray(nums, lo, hi, mid)))
        
        return max(self._maxSubArray(nums, lo, mid), self._maxSubArray(nums, mid, hi), self._maxCrossArray(nums, lo, hi, mid))

    
    def _maxCrossArray(self, nums, lo, hi, mid):
        
        temp_sum = 0
        max_left_sum = 0
        for i in range(mid-1, lo-1, -1):
            temp_sum += nums[i]
            if temp_sum > max_left_sum:
                max_left_sum = temp_sum    

            
        temp_sum = 0
        max_right_sum = 0
        for i in range(mid+1, hi):
            temp_sum += nums[i]
            if temp_sum > max_right_sum:
                max_right_sum = temp_sum
        
        return max_right_sum + max_left_sum + nums[mid]
            
            

solution = Solution()
print(solution.maxSubArray([-2,1,-3,4,-1,2,1,-5,4])) #6
print(solution.maxSubArray([1, 2])) #3             
        