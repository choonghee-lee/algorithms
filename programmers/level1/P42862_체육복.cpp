#include <vector>
#include <algorithm>

using namespace std;

void removeDuplicates(vector<int>& lost, vector<int>& reserve)
{
    int lostIndex = 0;
    int reserveIndex = 0;

    while (lostIndex < lost.size() && reserveIndex < reserve.size())
    {
        if(lost[lostIndex] == reserve[reserveIndex])
        {
            lost.erase(lost.begin() + lostIndex);
            reserve.erase(reserve.begin() + reserveIndex);
            continue;
        }
        else if(lost[lostIndex] > reserve[reserveIndex])
        {
            reserveIndex++;
        }
        else
        {
            lostIndex++;
        }
    }
}

void lendLostTracksuit(int& answer, vector<int>& lost, vector<int>& reserve)
{
    int lostIndex = 0;
    int reserveIndex = 0;

    while (lostIndex < lost.size() && reserveIndex < reserve.size())
    {
        int lender = reserve[reserveIndex];

        int frontBorrower = lender - 1;
        int rearBorrower = lender + 1;

        if(frontBorrower == lost[lostIndex] || rearBorrower == lost[lostIndex])
        {
            lost.erase(lost.begin() + lostIndex);
            reserveIndex++;

            answer++;
        }
        else if(lost[lostIndex] < reserve[reserveIndex])
        {
            lostIndex++;
        }
        else
        {
            reserveIndex++;
        }
    }
}

int solution(int n, vector<int> lost, vector<int> reserve) {

    // 입출력 예가 정렬되어있는 것은 페이크같다. 정렬!
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());

    // lost에도 있고 reserve에도 있으면 reserve에서 제거
    removeDuplicates(lost, reserve);

		// 무조건 참여 가능한 학생 수 
    int answer = n - lost.size();

    // 체육복 빌려주기
    lendLostTracksuit(answer, lost, reserve);

    return answer;
}

// +10점