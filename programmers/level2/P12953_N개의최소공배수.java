class Solution {
    
    public int 최대공약수(int a, int b) 
    {
        if(b == 0) return a;
        return 최대공약수(b, a % b);
    }
    
    public int 최소공배수(int a, int b)
    {
        return a * b / 최대공약수(a, b);
    }
    
    public int solution(int[] arr) {
        int answer = 0;
        for(int i = 0; i < arr.length - 1; i++)
        {
            int a = i == 0 ? arr[i] : answer;
            int b = arr[i + 1];
            
            answer = 최소공배수(a,b);
        }
        return answer;
    }
}