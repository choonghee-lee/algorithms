import java.util.*;

public class P18352_특정거리의도시찾기 {
    static void BFS(int current, ArrayList<Integer>[] A, int[] visited)
    {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(current);
        visited[current]++;

        while(!Q.isEmpty())
        {
            Integer item = Q.poll();
            for(int i : A[item])
            {
                if(visited[i] == -1) {
                    visited[i] = visited[item] + 1;
                    Q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 도시 수
        int M = sc.nextInt(); // 도로 수
        int K = sc.nextInt(); // 거리 정보
        int X = sc.nextInt(); // 출발 도시 정보

        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }

        int[] visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }

        BFS(X, A, visited);

        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i<=N; i++)
        {
            if(visited[i] == K)
                answer.add(i);
        }

        if(answer.isEmpty())
            System.out.println("-1");
        else
        {
            Collections.sort(answer);
            for(int i : answer)
            {
                System.out.println(i);
            }
        }
    }
}
