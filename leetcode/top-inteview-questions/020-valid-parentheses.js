/**
 * https://leetcode.com/problems/valid-parentheses/
 */

var isValid = function(s) {
    if(s.length % 2 != 0) return false;
    
    const arr = [...s];
    const stack = [];
    
    for (let i = 0; i < arr.length; i++) 
    {
        let p = undefined;
        
        if (arr[i] === ")") p = '(';
        if (arr[i] === "}") p = '{';
        if (arr[i] === "]") p = '[';
        
        if (p === undefined) 
        {
            stack.push(arr[i]);
            continue;
        }

        if (stack.pop() !== p) return false;
        
    }
    return stack.length === 0;
};
