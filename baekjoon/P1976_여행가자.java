import java.util.Scanner;

class P1976_여행가자 {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


        int[][] connections = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N; j++)
            {
                connections[i][j] = sc.nextInt();
            }
        }

        int[] route = new int[M + 1];
        for(int i = 1; i <= M; i++)
        {
            route[i] = sc.nextInt();
        }

        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++)
        {
            arr[i] = i;
        }

        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N; j++)
            {
                if(connections[i][j] == 1)
                    union(arr, i, j);
            }
        }

        int index = find(arr, route[1]);
        for(int i = 2; i < route.length; i++)
        {
            if(index != find(arr, route[i])) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}