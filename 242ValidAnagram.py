class Solution:
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        ds = {}
        dt = {}
        for c in s:
            if ds.__contains__(c):
                ds[c] += 1
            else:
                ds[c] = 1
        
        for c in t:
            if dt.__contains__(c):
                dt[c] += 1
            else:
                dt[c] = 1
        for c in ds.keys():
            if not dt.__contains__(c) or ds[c] != dt[c]:
                return False
        
        return True
