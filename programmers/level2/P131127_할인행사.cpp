#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    
    int answer = 0;
    
    std::unordered_map<string, int> wish_map;
    for(int i = 0; i < want.size(); i++)
    {
        wish_map[want[i]] = number[i];
    }
    
    for(int i = 0; i <= discount.size() - 10; i++) 
    {
        unordered_map<string, int> sale_map;
        for(int j = i; j < i + 10; j++) 
        {
            sale_map[discount[j]] += 1;
        }
        
        if(wish_map == sale_map)
        {
            answer++;
        }
    }
    
    return answer;
}