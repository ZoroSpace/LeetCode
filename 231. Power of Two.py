class Solution:
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n == 0:
            return False
        if n % 2 == 1:
            if n == 1:
                return True
            else :
                return False
        else :
            return self.isPowerOfTwo(n//2)
