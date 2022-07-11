class P1940_주몽
{
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
        {
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        int startIndex = 0;
        int endIndex = N - 1;

        while(startIndex < endIndex)
        {
            int sum = arr[startIndex] + arr[endIndex];
            if(sum == M)
            {
                count++;
                startIndex++;
                endIndex--;
            }
            else if(sum > M)
            {
                endIndex--;
            }
            else
            {
                startIndex++;
            }
        }

        // 출력
        System.out.println(count);
    }
}