public class 자릿수더히기 {
    public int solution(int n) {
        char[] arr = Integer.valueOf(n).toString().toCharArray();
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum += (arr[i] - '0');
        }

        return sum;
    }
}