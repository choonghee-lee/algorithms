class 최대공약수와최소공배수 {
    public int GCD(int a, int b)
    {
        if(b == 0)
            return a;

        return GCD(b, a % b);
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = GCD(n, m);
        answer[1] = n * m / answer[0];

        return answer;
    }
}