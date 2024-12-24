import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < my_string.length() ; i++)
        {
            list.add(
                new StringBuilder(new StringBuilder(my_string).reverse().toString().substring(0, i+1)).reverse().toString()
            );
        }
        Collections.sort(list);
        return list.stream()
            .toArray(String[]::new);
    }
}