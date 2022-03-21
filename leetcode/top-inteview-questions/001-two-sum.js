/*
 * https://leetcode.com/problems/two-sum/
 */

var twoSum = function (nums, target) {
  const dict = {};
  let result = [];

  for (let i = 0; i < nums.length; i++) {
    const v = nums[i];
    const e = target - v;
    if (v in dict) {
      result = [i, dict[v]];
      break;
    }
    dict[e] = i;
  }

  return result;
};
