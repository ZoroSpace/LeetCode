class Solution:
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        num_set = set(nums)
        return len(num_set) != len(nums)
        
        
