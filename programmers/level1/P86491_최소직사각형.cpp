#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    
    int width = 0;
    int height= 0;

    for(int i = 0; i < sizes.size(); i++){
        int n1 = sizes[i][0];
        int n2 = sizes[i][1];
        
        int bigger = max(n1, n2);
        int smaller = min(n1, n2);
        
        width = max(width, bigger);
        height = max(height, smaller);
    }
    
    return width * height;
}
