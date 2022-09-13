import java.io.IOException;
import java.util.Scanner;

class P1717_집합의표현 {

    public static int find(int[] parent, int a)
    {
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent, parent[a]);
    }

    public static void union(int[] parent, int a, int b)
    {
        a = find(parent, a);
        b = find(parent, b);
        if(a!=b)
        {
            parent[b] = a;
        }
    }

    public static boolean check(int[] parent, int a, int b)
    {
        a = find(parent, a);
        b = find(parent, b);
        return a == b;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] parent = new int[N + 1];
        for(int i = 0; i <= N; i++)
        {
            parent[i] = i;
        }

        for(int i = 0;  i < M; i++)
        {
            int q = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(q == 0)
            {
                union(parent, a, b);
            }
            else
            {
                if(check(parent, a,b))
                {
                    System.out.println("YES");
                }
                else
                {
                    System.out.println("NO");
                }
            }
        }
    }

}