import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P12910_나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % divisor == 0)
            {
                list.add(arr[i]);
            }
        }

        if(list.size() == 0)
        {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        else
        {
            int[] answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++)
            {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
            return answer;
        }
    }
}