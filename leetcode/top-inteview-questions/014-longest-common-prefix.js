/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
var longestCommonPrefix = function(strs) {
  if (strs.length === 0) return "";
  if (strs.length === 1) return strs[0];

  strs.sort();

  let end = Math.min(strs[0].length, strs[strs.length - 1].length);

  let i = 0;
  while (i < end && strs[0][i] === strs[strs.length - 1][i]) i++;

  return strs[0].substring(0, i);
};
