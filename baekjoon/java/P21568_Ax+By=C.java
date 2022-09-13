import java.io.*;
import java.util.StringTokenizer;

public class P21568_Ax+By=C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        br.close();

        long gcd = gcd(a,b);

        if(c % gcd != 0)
            System.out.println(-1);
        else
        {
            int quotient = (int) (c/gcd);
            long[] ret = euclid(a, b);
            System.out.println(ret[0] * quotient + " " + ret[1] * quotient);
        }
    }

    public static long[] euclid(long a, long b)
    {
        long[] ret = new long[2];
        if(b == 0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }

        long q = a / b;
        long[] v = euclid(b, a % b);
        ret[0] =  v[1];
        ret[1] =  v[0] - v[1] * q;
        return ret;
    }

    public static long gcd(long a, long b) {
        if(b == 0)
            return a;

        return gcd(b, a % b);
    }
}
