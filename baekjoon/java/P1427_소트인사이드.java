import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1427_소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] A = new int[input.length()];
        for(int i = 0; i < input.length(); i++)
        {
            A[i] = Integer.parseInt(input.substring(i, i + 1));
        }

        for(int i = 0; i < input.length(); i++) {
            int max = i;
            for(int j = i + 1; j < input.length(); j++)
            {
                if(A[j] > A[max])
                    max = j;
            }
            if(A[i] < A[max])
            {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        for(int i =0; i < input.length(); i++)
        {
            System.out.print(A[i]);
        }
    }
}
