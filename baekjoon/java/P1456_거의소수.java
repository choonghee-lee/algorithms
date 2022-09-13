import java.util.Scanner;

public class P1456_거의소수 {

    static final int TEN_POWER_OF_SEVEN = 10000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long[] arr = new long[TEN_POWER_OF_SEVEN + 1];

        for(int i = 2; i <= TEN_POWER_OF_SEVEN; i++)
        {
            arr[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(TEN_POWER_OF_SEVEN); i++)
        {
            if(arr[i] == 0) continue;

            for(int j = i + i; j <= TEN_POWER_OF_SEVEN; j = j + i)
            {
                arr[j] = 0;
            }
        }

        long count = 0;

        for(int i = 2; i <= TEN_POWER_OF_SEVEN; i++)
        {
            if(arr[i] == 0) continue;

            long t = arr[i];
            while((double)arr[i] <= (double)B/(double)t) {
                if((double)arr[i] >= (double)A/(double)t) {
                    count++;
                }

                t = t * arr[i];
            }
        }

        System.out.println(count);
    }
}
