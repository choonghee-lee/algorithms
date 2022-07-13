import java.util.Scanner;

public class P1747_소수와팰린드롬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[10000001];

        for (int i = 2; i < A.length; i++) A[i] = i;

        for (int i = 2; i < Math.sqrt(A.length); i++)
        {
            if(A[i] == 0) continue;

            for(int j = i + i; j < A.length; j = j + i)
            {
                A[j] = 0;
            }
        }

        for(int i = N; i < A.length; i++)
        {
            if(A[i] == 0) continue;

            if(isPalindrome(A[i]))
            {
                System.out.println(A[i]);
                break;
            }
        }
    }

    private static boolean isPalindrome(int num) {
        char[] chs = String.valueOf(num).toCharArray();
        int left = 0;
        int right = chs.length - 1;

        while(left < right)
        {
            if(chs[left] != chs[right]) return false;

            left++;
            right--;
        }

        return true;
    }
}
