/**
* https://leetcode.com/problems/reverse-string/
*/ 
function reverseString(s: string[]): void {
    let t;
    let l = 0;
    let r = s.length - 1;
    while(l < r)
    {
        t = s[l];
        s[l] = s[r];
        s[r] = t;
        
        l++;
        r--;
    }
};
