import java.util.*;

public class P1300_K번째수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        long K = sc.nextInt();

        long start = 1;
        long end = K;

        while(start <= end)
        {
            long mid = (start + end) / 2;
            long lessThanMidCount = 0;

            for(long i = 1; i <= N; i++)
            {
                lessThanMidCount += Math.min(mid / i, N);
            }

            if(lessThanMidCount < K)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(start);
    }
}
