import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String myString) {
        String[] arr = myString.split("x");
        List<String> list = Stream.of(arr)
            .collect(Collectors.toList());
        list = list.stream()
            .filter(idx -> idx.equals("") == false)
            .collect(Collectors.toList());
        Collections.sort(list);
        return list.stream()
            .toArray(String[]::new);
    }
}