class 약수의합 {
    public int solution(int n) {
        int sum = 0;

        for (int i = 1; i <= Math.sqrt(n); i++)
        {
            if(n % i == 0)
            {
                if(n / i == i)
                {
                    sum = sum + i;
                }
                else
                {
                    sum = sum + i;
                    sum = sum + (n / i);
                }
            }
        }

        return sum;
    }
}