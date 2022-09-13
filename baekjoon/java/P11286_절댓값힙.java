import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new PriorityQueue<>((n1, n2) -> {
            int abs1 = Math.abs(n1);
            int abs2 = Math.abs(n2);
            if(abs1 == abs2)
                return n1 > n2 ? 1 : -1;
            else
                return abs1 - abs2;
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < N; i++)
        {
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
            {
                if(Q.isEmpty())
                {
                    bw.write(0 + "\n");
                }
                else
                {
                    bw.write(Q.poll() + "\n");
                }
            }
            else
            {
                Q.add(n);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
