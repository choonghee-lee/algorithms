import java.io.*;
import java.util.*;

public class P1260_DFS와BFS {

    static int N;
    static int M;
    static int V;
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    static void BFS(int current)
    {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(current);
        visited[current] = true;

        while(!Q.isEmpty())
        {
            Integer item = Q.poll();
            System.out.print(item + " ");
            for(int i : A[item])
            {
                if(!visited[i]) {
                    visited[i] = true;
                    Q.add(i);
                }
            }
        }
    }

    static void DFS(int current)
    {
        System.out.print(current + " ");
        if(visited[current])
            return;

        visited[current] = true;
        for(int i: A[current]) {
            if(!visited[i])
                DFS(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];

        for(int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            A[U].add(T);
            A[T].add(U);
        }
        br.close();

        // 작은거 먼저 방문하려면 정렬
        for(int i = 1 ; i < N + 1; i++)
        {
            Collections.sort(A[i]);
        }

        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println();
    }
}
