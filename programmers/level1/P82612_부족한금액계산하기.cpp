using namespace std;

long long solution(int price, int money, int count)
{
    long long need = 0;
    
    for(int i = 1; i <= count; i++)
    {
       need +=  price * i;
    }
    
    return ((need - money) <= 0) ? 0 : need - money;
}