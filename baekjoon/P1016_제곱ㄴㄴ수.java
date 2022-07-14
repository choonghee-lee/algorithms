import java.util.Scanner;

public class P1016_제곱ㄴㄴ수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        int arraySize = (int)(max - min + 1);

        boolean[] A = new boolean[arraySize];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIndex = min / pow;
            if(min % pow != 0) startIndex++;
            for(long j = startIndex; j * pow <= max; j++) {
                A[(int)(j * pow - min)] = true;
            }
        }

        int count = 0;
        for(int i = 0; i <= max - min ; i++) {

            if(!A[i]) count++;
        }

        System.out.println(count);
    }
}
