import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public class DataStructureUtil {
        public Queue<Integer> arrayToQueue(int[] array) {
            List<Integer> integerList = Arrays.stream(array).boxed().collect(Collectors.toList());
            return new LinkedList<>(integerList);
        }
    }
    
    public class Sink {
        private Stack<Integer> ingredients;

        public Sink() {
            ingredients = new Stack<>();
        }

        public void takeIngredient(int ingredient) {
            ingredients.add(ingredient);
        }

        public int getIngredientSize() {
            return ingredients.size();
        }
        
        public void returnIngredients(List<Integer> ingredients) {
            for(int i = ingredients.size() - 1; i >= 0; i--) {
                this.ingredients.push(ingredients.get(i));
            }
        }

        public List<Integer> prepareBurgerIngredients() {
            List<Integer> burgerIngredients = new ArrayList<>();
            if(isBurgerable()) {
                burgerIngredients.add(ingredients.pop());
                burgerIngredients.add(ingredients.pop());
                burgerIngredients.add(ingredients.pop());
                burgerIngredients.add(ingredients.pop());
            }
            return burgerIngredients;
        }

        private boolean isBurgerable() {
            return ingredients.size() >= 4;
        }
    }

    public class Burger {
        private final List<Integer> burgerIngredients;
        
        public Burger(List<Integer> burgerIngredients) {
            this.burgerIngredients = burgerIngredients;
        }

        public boolean isServable() {
            if(burgerIngredients.size() != 4) return false;

            return burgerIngredients.get(0) == 1 &&
                    burgerIngredients.get(1) == 3 &&
                    burgerIngredients.get(2) == 2 &&
                    burgerIngredients.get(3) == 1;
        }
    }

    
    public int solution(int[] ingredient) {
        int answer = 0;
        DataStructureUtil util = new DataStructureUtil();
        Sink sink = new Sink();
        
        Queue<Integer> q = util.arrayToQueue(ingredient);
        while(!q.isEmpty())
        {
            sink.takeIngredient(q.poll());
            List<Integer> ingredients = sink.prepareBurgerIngredients();
            Burger burger = new Burger(ingredients);
            if(burger.isServable())
            {
                answer++;
                continue;
            }
            sink.returnIngredients(ingredients);
        }
        
        return answer;
    }
}