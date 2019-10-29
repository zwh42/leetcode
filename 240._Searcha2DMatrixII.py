class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        row_hi = len(matrix)
        if row_hi == 0:
            return False
        
        col_hi = len(matrix[0])
        if col_hi == 0:
            return False
        
        return self._searchMatrix(matrix, target, 0, row_hi, 0, col_hi)
    
    def _searchMatrix(self, matrix, target, row_lo, row_hi, col_lo, col_hi):
        if row_lo >= row_hi or col_lo >= col_hi:
            return False

        #print("row ,col: ", row_lo, row_hi, col_lo, col_hi)
        if (row_hi - row_lo <= 1) and (col_hi - col_lo <= 1):
            return matrix[row_lo][col_lo] == target
        
        row_mid = row_lo + (row_hi - row_lo) // 2
        col_mid = col_lo + (col_hi - col_lo) // 2

        '''
        for i in range(row_lo, row_hi):
            for j in range(col_lo, col_hi):
                print("{0:3d}, ".format(matrix[i][j]), end='')
            print()
        
        print("mid: ({}, {}) = {}， target = {}".format(row_mid, col_mid, matrix[row_mid][col_mid], target))
        
        input()
        '''
        
        
        if matrix[row_mid][col_mid] == target:
            return True
        elif matrix[row_mid][col_mid] < target:
            return self._searchMatrix(matrix, target, row_mid, row_hi, col_mid, col_hi) or \
                self._searchMatrix(matrix, target, row_lo, row_mid, col_mid, col_hi) or \
                    self._searchMatrix(matrix, target, row_mid, row_hi, col_lo, col_mid)

        else:
            return self._searchMatrix(matrix, target, row_lo, row_mid, col_lo, col_mid) or \
                self._searchMatrix(matrix, target, row_lo, row_mid, col_mid, col_hi) or \
                    self._searchMatrix(matrix, target, row_mid, row_hi, col_lo, col_mid)
            
            
solution = Solution()
print(solution.searchMatrix([[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], 5)) #True
print(solution.searchMatrix([[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], 20)) #False
print(solution.searchMatrix([[1,4],[2,5]], 2)) #True               