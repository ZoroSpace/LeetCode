class Solution:
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num < 1:
            return False
        return self.helper(num)
    
    def helper(self,num):
        if num % 2 == 0 or num % 3 == 0 or num % 5 == 0:
            if num % 2 == 0:
                return self.helper(num//2)
            if num % 3 == 0:
                return self.helper(num//3)
            if num % 5 == 0:
                return self.helper(num//5)
        elif num == 1:
            return True
        else:
            return False
