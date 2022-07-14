import java.util.Scanner;

public class P1850_최대공약수 {

    public static long GCD(long a, long b)
    {
        if(b == 0) return a;

        return GCD(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long result = GCD(A, B);

        StringBuilder sb = new StringBuilder();
        while(result > 0)
        {
            sb.append('1');
            result --;
        }

        System.out.println(sb);
    }
}
