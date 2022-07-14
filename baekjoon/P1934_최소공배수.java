import java.util.Scanner;

public class P1934_최소공배수 {

    public static int GCD(int a, int b)
    {
        if(b == 0) return a;

        return GCD(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++)
        {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int result = A * B / GCD(A, B);
            System.out.println(result);
        }
    }
}
