import java.util.*;

public class P12906_같은숫자는싫어 {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        Queue<Integer> Q = new LinkedList<>();

        for(int i = 0 ; i < arr.length; i++)
        {
            if(Q.isEmpty())
            {
                Q.offer(arr[i]);
                continue;
            }

            if(Q.peek() != arr[i])
            {
                int num = Q.poll();
                answer.add(num);
                Q.offer(arr[i]);
            }
        }

        if(!Q.isEmpty())
            answer.add(Q.poll());

        return answer.stream().mapToInt(i -> i).toArray();
    }
}