class Solution:
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        hi = 0
        lo = 0
        while hi < len(nums):
            if nums[hi]==0:
                hi+=1
            else:
                nums[lo]=nums[hi]
                lo+=1
                hi+=1
        
        for i in range(lo,hi):
            nums[i]=0
        
