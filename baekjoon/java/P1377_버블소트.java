import java.io.*;
import java.util.Arrays;

public class P1377_버블소트 {

    static class Node implements Comparable<Node>{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] A = new Node[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Node(i, Integer.parseInt(br.readLine()));
        }
        br.close();

        Arrays.sort(A);

        int max = 0;

        for(int i = 0; i < N; i++)
        {
            if(max < A[i].index - i)
            {
                max = A[i].index - i;
            }
        }
        System.out.println(max + 1);
    }
}
