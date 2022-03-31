/**
 * https://leetcode.com/problems/maximum-subarray/
 */
var maxSubArray = function(nums) {
    let realMax = nums[0];
    let fakeMax = nums[0];
    for(let i = 1; i < nums.length; i++) 
    {
        fakeMax = Math.max(nums[i], fakeMax + nums[i]);
        realMax = Math.max(realMax, fakeMax);
    }
    return realMax;
};
