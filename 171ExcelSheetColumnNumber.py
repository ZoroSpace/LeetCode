class Solution:
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        ans=0
        base=1
        for i in range(len(s)-1,-1,-1):
            ans+=base*(ord(s[i])-ord('A')+1)
            base*=26
        return ans
        
