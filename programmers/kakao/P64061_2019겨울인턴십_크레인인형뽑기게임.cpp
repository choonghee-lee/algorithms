#include <vector>
#include <stack>

using namespace std;

const int EMPTY_SPACE = 0;

void transpose(vector<vector<int>>& matrix)
{
    if (matrix.empty()) return;

    vector<vector<int>> transposed(matrix[0].size(), vector<int>());

    for (int i = 0; i < matrix.size(); i++)
    {
        for (int j = 0; j < matrix[i].size(); j++)
        {
            transposed[j].push_back(matrix[i][j]);
        }
    }

    matrix = transposed;
}

int grabDoll(vector<int>& line)
{
    int doll = EMPTY_SPACE;

    for(int i = 0; i < line.size(); i++)
    {
        if(line[i] == EMPTY_SPACE) continue;

        doll = line[i];
        line[i] = EMPTY_SPACE;

        break;
    }

    return doll;
}

bool killPairOfDolls(int doll, stack<int>& dollStack)
{
    bool hasKilled = false;

    if(doll == EMPTY_SPACE)
        return hasKilled;

    if(dollStack.empty() || doll != dollStack.top())
    {
        dollStack.push(doll);
        return hasKilled;
    }

    dollStack.pop();

    hasKilled = true;
    return hasKilled;
}

int solution(vector<vector<int>> board, vector<int> moves)
{
    int answer = 0;

    stack<int> dollStack;

	// 다른 배열을 자꾸 찾아다녀야해서 전치시킴
    transpose(board);

    for(int i = 0; i < moves.size(); i++)
    {
        int lineIndex = moves[i] - 1;

		// 인형 뽑아옴
        int doll = grabDoll(board[lineIndex]);

	    // 두개 붙은거 없애 
        bool hasKilled = killPairOfDolls(doll, dollStack);
        if(hasKilled)
        {
            answer += 2;
        }
    }

    return answer;
}