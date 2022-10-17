#include <string>
#include <vector>
#include <algorithm>

using namespace std;

const int ASTERISK = 10;
const int ZERO = 11;
const int HASH = 12;

class Hand
{
public:
    string hander;
    int left;
    int right;
    
public:
    Hand() : hander("left") { }
    
    Hand(string hander) {
        this->hander = hander;
        this->left = ASTERISK; 
        this->right = HASH; 
    }
    
    char moveLeftHand(int num)
    {
        this->left = num;
        return 'L';
    }
    
    char moveRightHand(int num)
    {
        this->right = num;
        return 'R';
    }
    
    char moveNearestHand(int num, int distanceFromLeft, int distanceFromRight)
    {
        if(distanceFromLeft == distanceFromRight)
        {
            return (this->hander == "right") ? this->moveRightHand(num) : this->moveLeftHand(num);
        }
        else if(distanceFromLeft > distanceFromRight)
        {
            return moveRightHand(num);
        }
        else
        {
            return moveLeftHand(num);
        }
    }
};

class Human
{
private:
    Hand* hand;
    
public:
    Human(string hander) {
        this->hand = new Hand(hander);
    }
    
    char pressNumber(int num) {
        switch(num)
        {
            case 1:
            case 4:
            case 7:
                return this->hand->moveLeftHand(num);
            case 3:
            case 6:
            case 9:
                return this->hand->moveRightHand(num);
            default:
                int distanceFromLeft = this->calculateDistance(num, this->hand->left);
                int distanceFromRight = this->calculateDistance(num, this->hand->right);
                return this->hand->moveNearestHand(num, distanceFromLeft, distanceFromRight);
        }
    }
    
private: 
    int calculateDistance(int targetNumber, int handNumber)
    {
        int distance = -1;
        int gap = abs(targetNumber - handNumber);
        
        switch(gap)
        {
            case 0:
                distance = 0;
                break;
            case 1:
            case 3: 
                distance = 1;
                break;
            case 2:
            case 4:
            case 6:
                distance = 2;
                break;
            case 5:
            case 7:
            case 9:
                distance = 3;
                break;
            default:
                distance = 4;
                break;
        }
        
        return distance;
    }
};

string solution(vector<int> numbers, string hand) {
    string answer = "";

    Human* human = new Human(hand);
    
    replace(numbers.begin(), numbers.end(), 0, ZERO);
    
    for(int number: numbers)
    {
        answer += human->pressNumber(number);
    }
    
    return answer;
}