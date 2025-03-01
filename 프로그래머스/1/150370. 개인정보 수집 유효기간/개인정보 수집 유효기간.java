import java.util.*;
class Solution {
    private HashMap<String, String> termMap = new HashMap<>();
    private String[] updated;
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        for(int i = 0 ; i < terms.length ; i++)
        {
            String[] arr = terms[i].split(" ");
            termMap.put(arr[0], arr[1]);
        }
        
        updated = new String[privacies.length];
        
        for(int i = 0 ; i < privacies.length ; i++)
        {
            String priv = privacies[i];
            String[] arr = priv.split(" ");
            String date = arr[0];
            String term = arr[1];
            int time = Integer.parseInt(termMap.get(term));
            
            String[] dateSplitArr = date.split("\\.");
            int month = Integer.parseInt(dateSplitArr[1]);
            int year = Integer.parseInt(dateSplitArr[0]);
            
            int totalMonth = month + time;
            year += totalMonth / 12;
            month = totalMonth % 12;
            if(month == 0)
            {
                month = 12;
                year--;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(year) + "." + String.valueOf(month) + "." + dateSplitArr[2]);
            System.out.println(sb);
            updated[i] = sb.toString();
        }
        List<Integer> answer = new ArrayList<>();
        for(int i = 0 ; i < privacies.length ; i++)
        {
            String update = updated[i];
            if(isExpired(today, update)) answer.add(i+1);
        }
        
        return answer;
    }
    private static boolean isExpired(String today, String target)
    {
        String[] tod = today.split("\\.");
        String[] tar = target.split("\\.");
        
        int todayYear = Integer.parseInt(tod[0]);
        int targetYear = Integer.parseInt(tar[0]);
            
        if(todayYear > targetYear)
        {
            return true;
        }
        else if(todayYear < targetYear)
        {
            return false;
        }
        
        int todayMonth = Integer.parseInt(tod[1]);
        int targetMonth = Integer.parseInt(tar[1]);
        
        if(todayMonth > targetMonth)
        {
            return true;
        }
        else if(todayMonth < targetMonth)
        {
            return false;
        }
        
        int todayDate = Integer.parseInt(tod[2]);
        int targetDate = Integer.parseInt(tar[2]);
        
        if(todayDate >= targetDate)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}