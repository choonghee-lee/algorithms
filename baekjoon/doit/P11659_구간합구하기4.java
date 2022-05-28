class P11659_구간합구하기4
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numSize = sc.nextInt();
        int querySize = sc.nextInt();

        // 입력
        int[] nums = new int[numSize];
        for(int i = 0; i < numSize; i++)
        {
            nums[i] = sc.nextInt();
        }

        // 합배열 만들기
        int[] sums = new int[numSize + 1];
        for(int i = 1; i <= numSize; i++)
        {
            sums[i] =  sums[i-1] + nums[i-1];
        }

        // 구간 입력 -> 구간 합 출력
        for(int i = 0; i < querySize; i++)
        {
            int j = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(sums[k] - sums[j-1]);
        }¨
    }
}