import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < my_string.length() ; i++)
        {
            try{
                list.add(Integer.parseInt(String.valueOf(my_string.charAt(i))));
            }
            catch(NumberFormatException e)
            {
                continue;
            }
        }
        Collections.sort(list);
        return list.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}