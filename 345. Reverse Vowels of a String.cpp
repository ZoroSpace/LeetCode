class Solution {
public:
    string reverseVowels(string s) {
        int lo = 0,hi = s.size()-1;
        string ans(s);
        string vowels("aeiouAEIOU");
        while(lo < hi) {
            if(vowels.find(s[lo]) == string::npos) {
                lo++;
                continue;
            }
            if(vowels.find(s[hi]) == string::npos) {
                hi--;
                continue;
            }
            ans[lo] = s[hi];
            ans[hi] = s[lo];
            lo++;
            hi--;
        }
        return ans;
    }
};
