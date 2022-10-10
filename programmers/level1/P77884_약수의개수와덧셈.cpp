using namespace std;

int getDivisorCount(int num)
{
    int divisorCount = 0;
    
    for(int i = 1; i * i <= num; i++)
    {
        if(num % i == 0)
        {
            divisorCount++;
            if(i * i < num)
            {
                divisorCount++;
            }
        }
    }

    return divisorCount;
}

int solution(int left, int right) {
    int answer = 0;
    
    for(int num = left; num <= right; num++)
    {
        int count = getDivisorCount(num);    
        
        if(count % 2 == 0)
            answer += num;
        else
            answer -= num;
    
    }
    
    return answer;
}