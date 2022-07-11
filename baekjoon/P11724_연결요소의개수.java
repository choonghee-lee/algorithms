class P11724_연결요소의개수 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    static void DFS(int i)
    {
        if(visited[i]) return;

        visited[i] = true;
        for(int j : A[i])
        {
            if(!visited[j]) DFS(j);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++)
        {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            A[U].add(V);
            A[V].add(U);
        }
        br.close();


        Integer count = 0;
        for(int i = 1; i <= N; i++)
        {
            if(!visited[i])
            {
                count++;
                DFS(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(count.toString());
        bw.flush();
        bw.close();
    }
}