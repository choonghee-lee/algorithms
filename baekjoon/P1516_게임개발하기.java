import java.util.*;

class P1516_게임개발하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i = 0; i <= N; i++)
        {
            A.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        int[] buildTime = new int[N + 1];

        for(int i = 1; i<= N; i++) {
            buildTime[i] = sc.nextInt();

            while (true) {
                int temp = sc.nextInt();
                if (temp == -1)
                    break;
                A.get(temp).add(i);
                inDegree[i]++;
            }

        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0)
            {
                queue.offer(i);
            }
        }

        int[] result = new int[N + 1];
        while (!queue.isEmpty())
        {
            int now = queue.poll();
            for (int next : A.get(now))
            {
                inDegree[next]--;
                result[next] = Math.max(result[next], result[now] + buildTime[now]);
                if(inDegree[next] == 0)
                {
                    queue.offer(next);
                }
            }
        }

        for(int i = 1; i <= N;i++)
        {
            System.out.println(result[i] + buildTime[i]);
        }
    }
}