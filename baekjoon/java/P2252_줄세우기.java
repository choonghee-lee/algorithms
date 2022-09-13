import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P2252_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 인접 리스트 초기화
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 진입 차수 배열
        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++)
        {
            // 학생 A, B  A->B
            int A = sc.nextInt();
            int B = sc.nextInt();
            list.get(A).add(B);
            inDegree[B]++;
        }

        // 위상 정렬
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i <= N; i++)
        {
            if(inDegree[i] == 0)
            {
                Q.offer(i);
            }
        }

        // 정답 배열
        ArrayList<Integer> answer = new ArrayList<>();

        // 위상 정렬 계속..
        while(!Q.isEmpty())
        {
            int current = Q.poll();
            answer.add(current);

            for(int i: list.get(current))
            {
                inDegree[i]--;
                if(inDegree[i] == 0)
                {
                    Q.offer(i);
                }
            }
        }

        // 출력
        for(int i : answer)
        {
            System.out.print(i + " ");
        }
    }
}