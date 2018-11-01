class Solution:
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n <= 0:
            return False
        num_set = set()
        num_sum = 0
        while not (n == 1 or num_set.__contains__(n)):
            num_set.add(n)
            num_sum = 0
            while n > 0:
                mod = n % 10
                num_sum += mod * mod
                n = n // 10
            n = num_sum
        if n == 1:
            return True
        else:
            return False
