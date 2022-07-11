class P10986_나머지합
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] nums = new long[N];
        long[] counts = new long[M];

        nums[0] = sc.nextInt();
        for(int i = 1; i < N; i++)
        {
            nums[i] = nums[i - 1] + sc.nextInt();
        }

        long answer = 0;
        for(int i = 0; i < N; i++)
        {
            int remainder = (int)(nums[i] % M);
            if(remainder == 0) answer++;
            counts[remainder]++;
        }

        for(int i = 0 ; i < M ; i++)
        {
            if(counts[i] > 1)
            {
                answer += counts[i] * (counts[i] - 1) / 2;
            }
        }
        System.out.println(answer);
    }
}