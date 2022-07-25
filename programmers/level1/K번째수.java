import java.util.Arrays;

class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++)
        {
            int[] com = commands[i];
            int from = com[0];
            int to = com[1];
            int k = com[2];

            int[] tmp = Arrays.copyOfRange(array, from - 1, to);
            Arrays.sort(tmp);
            answer[i] = tmp[k - 1];
        }
        return answer;
    }
}