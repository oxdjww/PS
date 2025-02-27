import java.util.*;

class Solution {
    private static HashMap<String, Integer> board = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();
    public String solution(String[] survey, int[] choices) {
        for(int i = 0 ; i < survey.length ; i++)
        {
            String first = String.valueOf(survey[i].charAt(0));
            String second = String.valueOf(survey[i].charAt(1));
            int choice = choices[i];
            if(choice > 4)
            {
                board.put(second, board.getOrDefault(second, 0) + choice - 4);
            }
            else if(choice < 4)
            {
                board.put(first, board.getOrDefault(first, 0) + Math.abs(choice - 4));
            }
        }
        
        String[][] data = new String[][]{
            {"R", "T"},
            {"C", "F"},
            {"J", "M"},
            {"A", "N"}
        };
        for(int i = 0 ; i < data.length ; i++)
        {
            String firstString = data[i][0];
            String secondString = data[i][1];
            int first = board.getOrDefault(firstString, 0);
            int second = board.getOrDefault(secondString, 0);
            if(first > second)
            {
                sb.append(firstString);
            }
            else if(first < second)
            {
                sb.append(secondString);
            }
            else
            {
                if(firstString.compareTo(secondString) < 0)
                {
                    sb.append(firstString);
                }
                else
                {
                    sb.append(secondString);
                }
            }
        }

        return sb.toString();
    }
}