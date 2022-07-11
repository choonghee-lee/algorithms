import java.io.*;

public class P2750_수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for(int i = 0; i < N; i++)
        {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        for(int i = 0; i < N - 1; i++)
        {
            for(int j = 0; j < N - 1 - i; j++)
            {
                if(A[j] > A[j+1])
                {
                    int T = A[j+1];
                    A[j + 1] = A[j];
                    A[j] = T;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++)
        {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
