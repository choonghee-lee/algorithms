import java.util.ArrayList;
import java.util.Scanner;

public class P1033_칵테일 {

    static ArrayList<Node>[] A;
    static long lcm;
    static boolean[] visited;
    static long[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;

        for(int i = 0; i < N; i++)
        {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            A[a].add(new Node(b, p, q));
            A[b].add(new Node(a, q, p));

            lcm *= p * q / GCD(p,q);
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for(int i = 1; i < N; i++)
        {
            mgcd = GCD(mgcd, D[i]);
        }

        for(int i = 0; i < N; i++)
        {
            System.out.print(D[i] / mgcd + " ");
        }
    }

    public static void DFS(int i) {
        visited[i] = true;
        for(Node n : A[i]) {
            int next = n.getB();
            if(!visited[next])
            {
                D[next] = D[i] * n.getQ() / n.getP();
                DFS(next);
            }
        }
    }

    public static long GCD(long a, long b)
    {
        if(b == 0) return a;

        return GCD(b, a % b);
    }

    static class Node {
        int b, p, q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}
