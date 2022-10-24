const unsigned int THAT_NUMBER = 1000000007;

int solution(int n) {
    if(n == 1) return 1;
    if(n == 2) return 2;
    
    int a = 1;
    int b = 2;
    int c = 0;
    
    for(int i = 0; i < n - 2; i++)
    {
        c = (a + b) % THAT_NUMBER;
        a = b;
        b = c;
    }
    
    return c;
}