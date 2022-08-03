class 정수제곱근판별 {
    public static double getSqrt(double num)
    {
        double tmp;
        double sqrt = num / 2;
        do {
            tmp = sqrt;
            sqrt = (tmp + (num / tmp)) / 2;
        } while ((tmp - sqrt) != 0);

        return sqrt;
    }

    public static long solution(long n)
    {
        double d = getSqrt(n);
        long t = d % (long) d != 0 ? -1 : (long) d;
        if(t == -1)
            return t;

        return (t + 1) * (t + 1);
    }
}