#include <regex>
#include <math.h>
#include <ctype.h>

using namespace std;

const string REGEX_DART_SCORE =  "^[0-9]{1,2}[SDT]{1}[*#]?";
const int TOTAL_DART_TRY = 3;

bool isNumber(const string& str)
{
    for(char const &ch : str)
    {
        if(isdigit(ch) == 0)
            return false;
    }
    return true;
}

int getScore(string& scoreStr)
{
    int score = 0;

    string temp = scoreStr.substr(0, 2);
    if(isNumber(temp))
    {
        score = 10;
    }
    else
    {
        score = scoreStr.at(0) - '0';
    }

    return score;
}

void applyBonus(int& score, const char& bonus)
{
    switch(bonus)
    {
        case 'D':
            score = pow(score, 2);
            break;
        case 'T':
            score = pow(score, 3);
            break;
        default:
            break;
    }
}

void applyOption(int* scores, const int& scoreIndex, const char& option)
{
    switch (option)
    {
        case '*':
            scores[scoreIndex] *= 2;
            if(scoreIndex > 0) scores[scoreIndex - 1] *= 2;
            break;
        case '#':
            scores[scoreIndex] *= -1;
            break;
        default:
            break;
    }
}

int getSumOfScores(const int* scores)
{
    int sum = 0;

    for(int i = 0; i < TOTAL_DART_TRY; i++)
    {
        sum += scores[i];
    }

    return sum;
}

int solution(string dartResult)
{
    regex rgx(REGEX_DART_SCORE);
    smatch match;

    int scores[] = {0, 0, 0};

    for(int i = 0; i < TOTAL_DART_TRY; i++)
    {
        // regex로 점수|보너스|[옵션] 문자열 찾아냄
        regex_search(dartResult, match, rgx);
        string scoreStr = match[0];

        // 0-10점 찾아 적용
        scores[i] = getScore(scoreStr);

        // 10이면 index가 하나 더 증가
        int nextIndex = (scores[i] < 10) ? 1 : 2;

        // 보너스 찾아서 power 연산
        char bonus = scoreStr.at(nextIndex);
        applyBonus(scores[i], bonus);

        // 스타상, 아차상 있으면 적용한다.
        char option = scoreStr[scoreStr.size() - 1];
        if(option == '#' || option == '*')
        {
            applyOption(scores, i, option );
        }

        // 처리한 다트 점수 문자열 지우기
        dartResult.erase(0, scoreStr.size());
    }

    // 점수 합산
    return getSumOfScores(scores);
}
