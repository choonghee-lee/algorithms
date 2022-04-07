/**
* https://leetcode.com/problems/valid-anagram/
*/
var isAnagram = function(s, t) {
    const sa = s.split('');
    const ta = t.split('');
    sa.sort();
    ta.sort();
    return sa.join('') === ta.join('');
};
