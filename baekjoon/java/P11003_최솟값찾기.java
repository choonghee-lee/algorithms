import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P11003_최솟값찾기 {
    static class Node {
        int index;
        long value;

        public Node(int index, long value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> deque =new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
            long current = Long.parseLong(st.nextToken());

            // 디큐의 마지막 위치에서 부터 현재값 보다 큰 값은 디큐에서 제거하기
            while(!deque.isEmpty() && deque.getLast().value > current)
            {
                deque.removeLast();
            }

            // 디큐의 마지막 위치에 현재값 저장
            deque.addLast(new Node(i, current));

            // 디큐의 첫번째 위치에서부터 L의 범위를 벗어난 값을 디큐에서 제거
            if(deque.getFirst().index <= i - L)
            {
                deque.removeFirst();
            }

            // 첫번째 데이터 출력
            bw.write(String.valueOf(deque.getFirst().value) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
