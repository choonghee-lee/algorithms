import java.util.*;

public class P1715_카드정렬하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> Q = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            Q.add(sc.nextInt());
        }

        int result = 0;
        while(Q.size() != 1) {
            int d1 = Q.poll();
            int d2 = Q.poll();
            result += d1 + d2;
            Q.add(d1+d2);
        }

        System.out.println(result);
    }
}
