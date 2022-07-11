import java.util.*;

public class P1920_수찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0 ; i < N ; i ++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int target = sc.nextInt();
            boolean isFound = false;

            int start = 0;
            int end = N-1;

            while(start <= end) {
                int medianIndex = (start + end) / 2;
                int median = A[medianIndex];

                if(median > target) {
                    end = medianIndex - 1;
                } else if (median < target) {
                    start = medianIndex + 1;
                } else {
                    isFound = true;
                    break;
                }
            }

            if(isFound) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
