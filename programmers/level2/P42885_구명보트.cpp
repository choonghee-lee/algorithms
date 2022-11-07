#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    sort(people.begin(), people.end());
    
    int answer = 0;
    int idx = 0;
    
    while(people.size() > idx)
    {
        int maxWeight = people.back();
        people.pop_back();
        
        answer++;
        if(people[idx] + maxWeight <= limit)
        {
            idx++;
        }
    }
    
    return answer;
}