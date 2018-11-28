class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = [0] * (len(nums)+2)
        for i in range(2,len(nums)+2):
            ans[i] = max(ans[i-1],ans[i-2]+nums[i-2])
        return ans[-1]
