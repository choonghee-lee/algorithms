import java.util.*;

public class P2108_통계학 {

    public static int countFreq(int[] A) {
        Map<Integer, Integer> mp = new HashMap<>();

        if (A.length == 1) {
            return A[0];
        }
        for (int i = 0; i < A.length; i++) {
            if (mp.containsKey(A[i])) {
                mp.put(A[i], mp.get(A[i]) + 1);
            } else {
                mp.put(A[i], 1);
            }
        }
        int maxValue = Collections.max(mp.values());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
            if (m.getValue() == maxValue) {
                arrayList.add(m.getKey());
            }
        }
        Collections.sort(arrayList);
        if (arrayList.size() > 1)
            return arrayList.get(1);
        else
            return arrayList.get(0);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        for(int i = 0; i < N; i++)
        {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        double avg = Arrays.stream(A).average().getAsDouble();
        int roundedAvg = (int) Math.round(avg);
        System.out.println(roundedAvg);

        int mid = N / 2;
        System.out.println(A[mid]);

        int freq = countFreq(A);
        System.out.println(freq);

        int range = A[N-1] - A[0];
        System.out.println(range);
    }
}