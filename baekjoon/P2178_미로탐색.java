import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static int[][] A;
    static boolean[][] V;

    static void BFS(int i, int j)
    {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{i, j});
        V[i][j] = true;

        while (!Q.isEmpty()) {
            int[] item = Q.poll();
            for(int k = 0; k < 4; k++)
            {
                int x = item[0] + dx[k];
                int y = item[1] + dy[k];

                if(x > -1 && y > -1 && x < N && y < M)
                {
                    if(A[x][y] == 1 && !V[x][y])
                    {
                        V[x][y] = true;
                        A[x][y] = A[item[0]][item[1]] + 1;
                        Q.add(new int[]{x, y});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        V = new boolean[N][M];

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int j = 0; j < M; j++)
            {
                A[i][j] = Integer.parseInt(S.substring(j, j + 1));
            }
        }
        br.close();

        BFS(0, 0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(A[N-1][M-1]));
        bw.flush();
        bw.close();
    }
}
