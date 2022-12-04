import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] toppings) {
        
        int answer = 0;
        
        Map<Integer, Integer> chulsoo = new HashMap<>();
        Set<Integer> bro = new HashSet<>();
        
        for(int topping: toppings) 
        {
            chulsoo.put(topping, chulsoo.getOrDefault(topping, 0) + 1);
        }
        
        for(int topping2: toppings)
        {
            chulsoo.put(topping2, chulsoo.get(topping2) - 1);
            bro.add(topping2);
            
            if(chulsoo.get(topping2) == 0)
                chulsoo.remove(topping2);
            
            if(chulsoo.size() == bro.size())
                answer += 1;
        }
        
        return answer;
    }
}