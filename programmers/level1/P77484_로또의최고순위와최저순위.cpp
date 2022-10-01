#include <vector>

using namespace std;

int getRank(int sum) {
    
    switch (sum) {
        case 6:
            return 1;
        case 5:
            return 2;
        case 4:
            return 3;
        case 3:
            return 4;
        case 2:
            return 5;
        default:
            return 6;
    }
}


vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    
    int match = 0;
    int zero = 0;

    for (int lotto : lottos)
    {
        zero += !lotto;

        for (int win_num : win_nums)
        {
            match += (lotto == win_num);
        }
    }

    return {getRank(match + zero), getRank(match)};
}