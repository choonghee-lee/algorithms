import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023_ABCDE {

    static int N;
    static int M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean hasArrived;

    static void DFS(int i, int depth)
    {
        if(depth == 5 || hasArrived) {
            hasArrived = true;
            return;
        }

        visited[i] = true;
        for(int j : A[i])
        {
            if(!visited[j])
                DFS(j, depth + 1);
        }
        visited[i] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        visited = new boolean[N];
        hasArrived = false;

        for(int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            A[U].add(V);
            A[V].add(U);
        }
        br.close();

        for(int i = 0; i < N; i++)
        {
            DFS(i, 1);
            if(hasArrived)
                break;
        }

        if(hasArrived)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
