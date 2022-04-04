/**
* https://leetcode.com/problems/valid-palindrome/
*/

function isPalindrome(s: string): boolean {
    let ns = s.toLowerCase();
    ns = ns.replace(/[^A-Za-z0-9]/g, "");
    let l = 0;
    let r = ns.length - 1;
    while(l < r){
        if(ns[l] != ns[r]) return false;
        l++;
        r--;
    }
    return true;
};
