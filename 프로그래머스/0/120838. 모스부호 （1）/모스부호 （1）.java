import java.util.*;
class Solution {
    HashMap<String,String> hm = new HashMap<>();
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        init();
        for(String str : letter.split(" "))
        {
            sb.append(hm.get(str));
        }
        return sb.toString();
    }
    private void init()
    {
        hm.put(".-", "a");
        hm.put("-...", "b");
        hm.put("-.-.", "c");
        hm.put("-..", "d");
        hm.put(".", "e");
        hm.put("..-.", "f");
        hm.put("--.", "g");
        hm.put("....", "h");
        hm.put("..", "i");
        hm.put(".---", "j");
        hm.put("-.-", "k");
        hm.put(".-..", "l");
        hm.put("--", "m");
        hm.put("-.", "n");
        hm.put("---", "o");
        hm.put(".--.", "p");
        hm.put("--.-", "q");
        hm.put(".-.", "r");
        hm.put("...", "s");
        hm.put("-", "t");
        hm.put("..-", "u");
        hm.put("...-", "v");
        hm.put(".--", "w");
        hm.put("-..-", "x");
        hm.put("-.--", "y");
        hm.put("--..", "z");
    }
}