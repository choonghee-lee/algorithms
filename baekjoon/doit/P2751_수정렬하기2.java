import java.io.*;
import java.util.StringTokenizer;

public class P2751_수정렬하기2 {

    static int[] A, T ;

    public static void sort(int start, int end)
    {
        if(end - start < 1) return;

        int mid = start + (end - start) / 2;

        sort(start, mid);
        sort(mid+1, end);

        for(int i = start; i <= end; i++)
        {
            T[i] = A[i];
        }

        int i = start;
        int index1 = start;
        int index2 = mid + 1;

        while(index1 <= mid && index2 <= end)
        {
            if(T[index1] > T[index2])
            {
                A[i] = T[index2];
                i++;
                index2++;
            }
            else
            {
                A[i] = T[index1];
                i++;
                index1++;
            }
        }

        while(index1 <= mid)
        {
            A[i] = T[index1];
            i++;
            index1++;
        }

        while(index2 <= end)
        {
            A[i] = T[index2];
            i++;
            index2++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        A = new int[N];
        T = new int[N];

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }

        sort(0, N-1);

        for(int i = 0; i < N; i++)
        {
            bw.write(A[i] + "\n");
        }

        br.close();
        bw.close();
    }
}
