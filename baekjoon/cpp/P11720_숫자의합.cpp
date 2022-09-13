#include <iostream>

int main()
{
  int N;
  std::cin >> N;

  char T;
  int S = 0;

  for(int i = 0; i < N; i++)
  {
    std::cin >> T;
    S += (T - '0');
  }

  std::cout << S << std::endl;
}