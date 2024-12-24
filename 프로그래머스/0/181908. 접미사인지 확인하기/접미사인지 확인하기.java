import java.util.*;
class Solution {
    public int solution(String my_string, String is_suffix) {
        HashSet<String> hs = new HashSet<>();
        for(int i = 0 ; i < my_string.length() ; i++)
        {
            hs.add(
                my_string.substring(i, my_string.length())
            );
        }
        return hs.contains(is_suffix) ? 1 : 0;
    }
}