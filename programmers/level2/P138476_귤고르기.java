import java.util.*;

class Solution {
    public class TangerineClassifier {
        
        public Map<Integer, Integer> count(int[] tangerines) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for(int t: tangerines) {
                countMap.put(t, countMap.getOrDefault(t, 0) + 1);
            }
            return countMap;
        }

        public List<Integer> sort(final Map<Integer, Integer> countMap) {
            List<Integer> tangerines = new ArrayList<>(countMap.keySet());
            tangerines.sort((t1, t2) -> countMap.get(t2) - countMap.get(t1));
            return tangerines;
        }

        public int box(Map<Integer, Integer> countMap, List<Integer> tangerineList, int k) {
            int kk = k;
            int tangerine = 0;
            int answer = 0;
            while(kk > 0) {
                kk -= countMap.get(tangerineList.get(tangerine));
                answer++;
                tangerine++;
            }
            return answer;
        }
    }
    
    public int solution(int k, int[] tangerine) {
        TangerineClassifier classifier = new TangerineClassifier();
        Map<Integer, Integer> countMap = classifier.count(tangerine);
        List<Integer> tangerines = classifier.sort(countMap);
        return classifier.box(countMap, tangerines, k);
    }
}