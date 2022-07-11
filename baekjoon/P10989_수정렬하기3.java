class P10989_수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[10001];
        for(int i = 0; i < N; i++)
        {
            A[Integer.parseInt(br.readLine())]++;
        }
        br.close();

        for(int i = 1; i < 10001; i++)
        {
            while(A[i] > 0)
            {
                bw.write(i + "\n");
                A[i]--;
            }
        }
        bw.flush();
        bw.close();
    }
}