import java.io.*;
import java.util.StringTokenizer;

public class P11004_K번째수 {

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr, int left, int right)
    {
        if(left >= right)
        {
            return;
        }

        int pivot = partition(arr, left, right);
        sort(arr, left, pivot);
        sort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right)
    {
        int tLeft = left - 1;
        int tRight = right + 1;
        int pivot = arr[(left + right) / 2];

        while (true)
        {
            do {
                tLeft++;
            } while (arr[tLeft] < pivot);

            do {
                tRight--;
            } while(arr[tRight] > pivot && tLeft <= tRight);

            if(tLeft >= tRight)
                return tRight;

            swap(arr, tLeft, tRight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N;i ++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        sort(A, 0, N-1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(A[K-1]));
        bw.flush();
        bw.close();
    }
}
