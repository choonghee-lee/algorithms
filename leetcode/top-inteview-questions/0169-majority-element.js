/**
* https://leetcode.com/problems/majority-element/
*/
var majorityElement = function(nums) {
    const counter = {};
    nums.forEach(n => {
        if(n in counter) {
            counter[n] = counter[n] + 1;
        } else {
            counter[n] = 1;
        }
    })
    const keys = Object.keys(counter);
    let majority = keys[0];
    keys.forEach(k => {
        if(counter[k] > counter[majority])
            majority = k;
    })
    return majority;
};
