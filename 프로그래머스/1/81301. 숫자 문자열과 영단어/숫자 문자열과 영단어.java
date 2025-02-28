import java.util.*;

class Solution {
    public int solution(String s) {
        String[] numberStringArray = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        HashMap<String, Integer> db = new HashMap<>();
        for(int i = 0 ; i < 10 ; i++)
        {
            db.putIfAbsent(numberStringArray[i], i);
        }
        String answer = "";
        char[] arr = s.toCharArray();
        String sub = "";
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(Character.isDigit(arr[i]))
            {
                answer += String.valueOf(arr[i]);
            }
            else
            {
                sub += String.valueOf(arr[i]);
                if (db.containsKey(sub.toString())) {
                    answer += db.get(sub.toString());
                    sub = "";
                }
            }
        }
        return Integer.parseInt(answer);
    }
}