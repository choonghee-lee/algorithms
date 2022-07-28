import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

    public static void BFS(ArrayList<Integer>[] A, boolean[] visited, int[] answer, int current)
    {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(current);
        visited[current] = true;

        while (!Q.isEmpty()) {
            Integer item = Q.poll();
            for (int i : A[item]) {
                if(!visited[i])
                {
                    visited[i] = true;
                    answer[i]++;
                    Q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
        {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++)
        {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }

        int[] answer = new int[N + 1];
        boolean[] visited;
        for(int i = 1; i <= N; i++)
        {
            visited = new boolean[N + 1];
            BFS(A, visited, answer, i);
        }

        int maxVal = 0;
        for(int i = 1; i <= N; i++)
        {
            maxVal = Math.max(maxVal, answer[i]);
        }

        for(int i = 1; i <= N; i++)
        {
            if (answer[i] == maxVal) {
                System.out.print(i + " ");
            }
        }
    }
}