import java.util.*;

public class P1541_잃어버린괄호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();

        String[] A1 = expression.split("-");

        int result = 0;
        int sum = 0;
        for(int i = 0; i < A1.length; i++) {

            String[] A2 = A1[i].split("\\+");

            for(String item2: A2)
            {
                sum += Integer.parseInt(item2);
            }

            if(i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
            sum = 0;
        }

        System.out.println(result);
    }
}
