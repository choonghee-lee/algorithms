import java.io.*;

public class P2023_신기한소수찾기 {

    static int N;

    static boolean isPrimeNumber(int num)
    {
        for(int i = 2; i <= num / 2; i++)
        {
            if(num % i == 0) return false;
        }
        return true;
    }

    static void DFS(int digit, int num) {

        if(digit == N)
        {
            if(isPrimeNumber(num))
            {
                System.out.println(num);
            }
            return;
        }

        for(int i = 1; i < 10; i++)
        {
            if(i % 2 == 0)
            {
                continue;
            }

            if(isPrimeNumber(num * 10 + i))
            {
                DFS(digit + 1, num * 10 + i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(1, 2);
        DFS(1, 3);
        DFS(1, 5);
        DFS(1, 7);
    }
}
