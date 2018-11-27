class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        counter = 0
        while n > 0:
            counter = counter + n % 2
            n = n // 2
        return counter
