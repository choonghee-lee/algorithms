import java.util.ArrayList;
import java.util.Scanner;

class P1043_거짓말 {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 진실을 아는 사람들 초기화
        int T = sc.nextInt();
        int[] PT = new int[T];
        for(int i = 0; i < T; i++)
        {
            PT[i] = sc.nextInt();
        }

        // 파티 초기화
        ArrayList<Integer>[] party = new ArrayList[M];
        for(int i = 0; i < M; i++)
        {
            party[i] = new ArrayList<>();
            int PS = sc.nextInt();

            for(int j = 0; j < PS; j++)
            {
                party[i].add(sc.nextInt());
            }
        }

        // 대표 노드 자기 자신으로 초기화
        int[] parent = new int[N + 1];
        for(int i = 1; i <= N; i++)
        {
            parent[i] = i;
        }
        for(int i = 0; i < M; i++)
        {
            int first = party[i].get(0);
            for(int j = 1; j < party[i].size(); j++)
            {
                union(parent, first, party[i].get(j));
            }
        }

        int answer = 0;
        for(int i = 0; i < M; i++)
        {
            boolean canLie = true;
            int current = party[i].get(0);
            for(int j = 0;  j < PT.length; j++)
            {
                if(find(parent, current) == find(parent, PT[j]))
                {
                    canLie = false;
                    break;
                }
            }

            if(canLie)
            {
                answer++;
            }
        }

        System.out.println(answer);
    }
}