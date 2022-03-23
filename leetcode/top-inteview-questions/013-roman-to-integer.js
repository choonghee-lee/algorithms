/*
 * https://leetcode.com/problems/roman-to-integer/
 */
var romanToInt = function (s) {
  const romanDict = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000,
    IV: 4,
    IX: 9,
    XL: 40,
    XC: 90,
    CD: 400,
    CM: 900,
  };
  
  let result = 0;
  const romans = s.split("");
  for (let i = 0; i < romans.length; i++) {
    const fc = romans[i];
    const sc = romans[i + 1] ? romans[i + 1] : "";
    const t = fc + sc;
    if (t in romanDict) {
      result += romanDict[t];
      i++;
    } else {
      result += romanDict[fc];
    }
  }
  return result;
};
