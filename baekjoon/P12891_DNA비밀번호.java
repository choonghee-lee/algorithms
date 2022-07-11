import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {

    static boolean isPasswordable(Map<Character, Integer> counter, int A, int C, int G, int T)
    {
        if(counter.get('A') < A) return false;
        if(counter.get('C') < C) return false;
        if(counter.get('G') < G) return false;
        if(counter.get('T') < T) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Map<Character, Integer> counter = new HashMap<>();
        counter.put('A', 0);
        counter.put('C', 0);
        counter.put('G', 0);
        counter.put('T', 0);

        int answer = 0;


        for(int i = 0; i < P ; i++)
        {
            char k = arr[i];
            counter.put(k, counter.get(k) + 1);
        }

        if(Main.isPasswordable(counter, A, C, G, T))
        {
            answer++;
        };


        int i = 0;
        int j = P;

        while(j < S)
        {
            char subKey = arr[i];
            char addKey = arr[j];

            counter.put(subKey, counter.get(subKey) - 1);
            counter.put(addKey, counter.get(addKey) + 1);

            if(Main.isPasswordable(counter, A, C, G, T))
            {
                answer++;
            };

            i++;
            j++;
        }

        System.out.println(answer);

        br.close();
    }
}
