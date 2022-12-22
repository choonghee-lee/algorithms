import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // 종류별로 개수 챱챱
        Map<String, Integer> 해쉬맵 = new HashMap<>();
        for(String[] 옷: clothes)
        {
            String 의상종류 = 옷[1];
            해쉬맵.put(의상종류, 해쉬맵.getOrDefault(의상종류, 1) + 1);
        }

        // 조합 계산
        return 해쉬맵.values()
                .stream()
                .reduce(1, (a, b) -> a*b) - 1;
    }
}