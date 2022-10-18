class Solution {
    public String solution(String s) 
    {
        String[] splits = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String split: splits)
        {
            int num = Integer.parseInt(split);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        return min + " " + max;
    }
}