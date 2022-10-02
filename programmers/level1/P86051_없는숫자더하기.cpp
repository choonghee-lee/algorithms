#include <numeric>
#include <vector>

using namespace std;

int solution(vector<int> numbers) {
    return 45 - accumulate(numbers.begin(), numbers.end(), 0);
}