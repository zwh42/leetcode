class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        max_length = 0
        for i in range(len(s)):
            char_set = set()
            length = 0
            for j in range(i, len(s)):
                if s[j] not in char_set:
                    char_set.add(s[j])
                    length += 1
                else: 
                    break
            if length > max_length:
                max_length = length
        
        return max_length
        