import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++)
        {
            A[i] = sc.nextInt();
        }

        int num = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; i++)
        {
            if(A[i] >= num)
            {
                while(A[i] >= num)
                {
                    stack.push(num++);
                    sb.append("+\n");
                }

                stack.pop();
                sb.append("-\n");
            }
            else
            {
                int n = stack.pop();
                if(A[i] < n)
                {
                    System.out.println("NO");
                    sb = new StringBuffer();
                    break;
                }
                else
                {
                    sb.append("-\n");
                }
            }
        }

        if(!sb.toString().isEmpty())
            System.out.println(sb);
    }
}