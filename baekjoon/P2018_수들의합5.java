class P2018_수들의합5
{
    public static void main(String[] args) throws IOException {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 초기화
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        int count = 0;

        while(endIndex < (N + 1))
        {
            if(sum == N)
            {
                endIndex++;
                sum += endIndex;
                count++;
            }
            else if(sum > N)
            {
                sum -= startIndex;
                startIndex++;
            }
            else
            {
                endIndex++;
                sum += endIndex;
            }
        }

        // 출력
        System.out.println(count);
    }
}