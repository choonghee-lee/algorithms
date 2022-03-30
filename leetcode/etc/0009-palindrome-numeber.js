/**
* https://leetcode.com/problems/palindrome-number/
*/
var isPalindrome = function(x) {
    if (x < 0) return false;
    
    const arr = String(x).split('');
    let l = 0; let r = arr.length - 1;
    while(l <= r)
    {
        if (arr[l] !== arr[r]) return false;
        l++; r--;
    }
    
    return true;
};
