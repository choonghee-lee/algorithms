import java.util.*;

public class P1167_트리의지름 {

    static class Node {
        int value;
        int edge;

        public Node(int value, int edge) {
            this.value = value;
            this.edge = edge;
        }

        public int getValue() {
            return value;
        }

        public int getEdge() {
            return edge;
        }
    }

    static int N;
    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            int j = sc.nextInt();
            while(true) {
                int e = sc.nextInt();
                if(e == -1)
                    break;
                int v = sc.nextInt();
                A[j].add(new Node(v, e));
            }
        }

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        BFS(1);
        int max = 1;
        for(int i = 2; i <= N; i++) {
            if(distance[max] < distance[i]) {
                max = i;
            }
        }

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Node node : A[current]) {
                int e = node.getEdge();
                int v = node.getValue();
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[current] + v;
                }
            }
        }
    }
}
