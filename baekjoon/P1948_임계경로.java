import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P1948_임계경로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> A = new ArrayList<>();
        ArrayList<ArrayList<Node>> R = new ArrayList<>();

        for(int i = 0; i <= N; i++)
        {
            A.add(new ArrayList<>());
            R.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        for(int i = 0; i < M; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            A.get(S).add(new Node(E, V));
            R.get(E).add(new Node(S, V));
            inDegree[E]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startCity);
        int[] result = new int[N + 1];
        while (!queue.isEmpty())
        {
            int now = queue.poll();
            for (Node next : A.get(now))
            {
                inDegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);

                if(inDegree[next.targetNode]  == 0)
                {
                    queue.offer(next.targetNode);
                }
            }
        }

        int resultCount = 0;
        boolean visited[] = new boolean[N + 1];
        queue = new LinkedList<>();
        queue.offer(endCity);
        visited[endCity] = true;

        while (!queue.isEmpty())
        {
            int now = queue.poll();
            for (Node next : R.get(now))
            {
                if(result[next.targetNode] + next.value == result[now])
                {
                    resultCount++;

                    if(visited[next.targetNode] == false)
                    {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }

        System.out.println(result[endCity]);
        System.out.println(resultCount);
    }

    static class Node {
        int targetNode;
        int value;

        public Node(int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }

        public int getTargetNode() {
            return targetNode;
        }

        public int getValue() {
            return value;
        }
    }
}