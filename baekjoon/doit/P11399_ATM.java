import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P11399_ATM {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];
        for(int i = 0; i < N; i++){
            P[i] = sc.nextInt();
        }

        for(int i = 1; i < N; i++) {
            int insertIndex = 1;
            int V = P[i];
            for(int j = i - 1; j > -1; j--)
            {
                if(P[j] < V)
                {
                    insertIndex = j + 1;
                    break;
                }

                if(j == 0)
                {
                    insertIndex = 0;
                }
            }

            for(int j = i; j > insertIndex; j--)
            {
                P[j] = P[j - 1];
            }

            P[insertIndex] = V;
        }

        int[] S = new int[N];
        S[0] = P[0];
        for(int i = 1; i < N; i++)
        {
            S[i] = S[i - 1] + P[i];
        }

        System.out.print(Arrays.stream(S).sum());
    }
}
