import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class P1916_최소비용구하기 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.readLine();
        int M = Integer.parseInt(br.readLine());
        br.readLine();

        ArrayList<Edge>[] list = new ArrayList[N + 1];
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i <= N;i ++)
        {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end, weight));
            br.readLine();
        }

        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());

        int answer = dijkstra(startIndex, endIndex, distance, visited, list);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra(int start, int end, int[] distance, boolean[] visited, ArrayList<Edge>[] list)
    {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start, 0));
        distance[start] = 0;

        while (!q.isEmpty())
        {
            Edge current = q.poll();
            int currentVertex = current.vertex;

            if(visited[currentVertex])
                continue;

            visited[currentVertex] = true;

            for(int i = 0; i < list[currentVertex].size(); i++)
            {
                Edge tmp = list[currentVertex].get(i);
                int next = tmp.vertex;
                int value = tmp.value;

                if(distance[next] > distance[currentVertex] + value)
                {
                    distance[next] = value + distance[currentVertex];
                    q.add(new Edge(next, distance[next]));
                }
            }
        }

        return distance[end];
    }

    static class Edge implements Comparable<Edge> {
        int vertex, value;

        Edge(int vertex,int value)
        {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(@NotNull Edge o) {
            if(this.value > o.value)
                return 1;
            else
                return -1;
        }
    }
}