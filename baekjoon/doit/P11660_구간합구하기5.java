import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arraySize = Integer.parseInt(st.nextToken());
        int querySize = Integer.parseInt(st.nextToken());

        // 배열 입력
        int[][] array = new int[arraySize+1][arraySize+1];
        for(int i = 1; i <= arraySize; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= arraySize; j++)
            {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 합배열 만들기
        int[][] sums = new int[arraySize+1][arraySize+1];
        for(int i = 1; i <= arraySize; i++)
        {
            for(int j = 1; j <= arraySize; j++)
            {
                sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1] + array[i][j];
            }
        }

        // 구간 입력 -> 구간합 구하기
        for(int i = 0; i < querySize; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1-1] + sums[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}
