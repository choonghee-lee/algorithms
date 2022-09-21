#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {

    // 100,000 * 100,000 => O(n^2)으로 풀지마세요
    // completion의 길이는 participant의 길이보다 1 작습니다.
    // 알파벳 소문자
    // 동명이인 가능

    sort(participant.begin(), participant.end());
    sort(completion.begin(), completion.end());

    string answer = "";

    for (int i = 0; i < completion.size(); i++)
    {
        if(participant[i] != completion[i])
        {
            answer = participant[i];
            break;
        }
    }

    if(answer == "")
    {
        answer = participant.back();
    }

    return answer;
}