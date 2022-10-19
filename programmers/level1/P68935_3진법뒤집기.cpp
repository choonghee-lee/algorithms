#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int solution(int n) {
    vector<int> ret;
    
    while (n != 0)
    {
        ret.push_back(n % 3); 
        n /= 3;
    }
    
    reverse(ret.begin(), ret.end());
    
    for (int i = 0; i < ret.size(); ++i)
    {
        n += pow(3, i) * ret[i];
    }
    
    return n;
}
