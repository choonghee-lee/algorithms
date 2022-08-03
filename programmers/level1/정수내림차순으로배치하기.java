import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

class 정수내림차순으로배치하기 {
    public long solution(long n) {
        Character[] arr = Long.valueOf(n).toString().chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        return Long.parseLong(Arrays.stream(arr).map(Objects::toString).collect(Collectors.joining()));
    }
}