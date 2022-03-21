/*
 * https://leetcode.com/problems/contains-duplicate/
 */
var containsDuplicate = function (nums) {
  const dict = {};
  let result = false;
  for (let i = 0; i < nums.length; i++) {
    const key = nums[i];
    if (key in dict) {
      result = true;
      break;
    }
    dict[key] = 1;
  }
  return result;
};
