class Solution:
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        ans = []
        lo = 0
        hi = len(numbers)-1
        while lo < hi:
            if numbers[lo] + numbers[hi] < target:
                lo += 1
            elif numbers[lo] + numbers[hi] > target:
                hi -= 1
            else:
                break
        ans.append(lo+1)
        ans.append(hi+1)
        return ans
