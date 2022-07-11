import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class P2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new LinkedList<>();

        for(int i = 1; i <= N; i++)
        {
            Q.add(i);
        }

        while(Q.size() > 1)
        {
            Q.poll();
            Q.add(Q.poll());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(Q.peek()));

        br.close();
        bw.flush();
        bw.close();
    }
}
