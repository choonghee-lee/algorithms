class P1546_평균
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] scores = new int[size];
        for(int i = 0; i < size; i++)
        {
            scores[i] = sc.nextInt();
        }

        int sumOfScores = 0;
        int maxScore = 0;
        for(int i = 0; i <size; i++)
        {
            sumOfScores += scores[i];
            if(scores[i] > maxScore)
            {
                maxScore = scores[i];
            }
        }
        double result = (sumOfScores * 100.0 / maxScore) / size;
        System.out.print(result);
    }
}