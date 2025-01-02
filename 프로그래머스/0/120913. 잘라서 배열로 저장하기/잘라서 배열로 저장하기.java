import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String my_str, int n) {
        List<String> list = new ArrayList<>();
        
        for(int i = 0 ; i < my_str.length() ; i+=n)
        {
            try{
                list.add(my_str.substring(i, i+n));
            }catch(StringIndexOutOfBoundsException e)
            {
                list.add(my_str.substring(i));
            }
        }
        
        return list.stream()
            .toArray(String[]::new);
    }
}