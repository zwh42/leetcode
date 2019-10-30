class Solution:
    def minCostClimbingStairs(self, cost):
        result = [0] * (len(cost) + 1) 
        result[0] = cost[0]
        result[1] = cost[1]
        for i in range(2, len(cost) + 1):
            if i == len(cost):
                result[i] = min(result[i-1], result[i-2])
            else:
                result[i] = min(result[i-1], result[i-2]) + cost[i]
        
        return result[len(cost)]


solution = Solution()
print(solution.minCostClimbingStairs([10, 15, 20])) #15
print(solution.minCostClimbingStairs([1, 100, 1, 1, 1, 100, 1, 1, 100, 1])) #6
             

