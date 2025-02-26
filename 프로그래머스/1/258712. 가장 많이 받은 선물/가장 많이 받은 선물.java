import java.util.*;

class Solution {
    HashMap<String, Integer> hm = new HashMap<>();
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;
        int[][] thisMonth = new int[N][N];
        int[] give = new int[N];
        int[] receive = new int[N];
        int[] giftScore = new int[N];
        int[] nextMonth = new int[N];
                
        for(int i = 0 ; i < friends.length ; i++)
        {
            hm.put(friends[i], i);
        }
        
        for(int i = 0 ; i < gifts.length ; i++)
        {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            int from = hm.get(st.nextToken());
            int to = hm.get(st.nextToken());
            
            thisMonth[from][to]++;
        }
        
        for(int i = 0 ; i < thisMonth.length ; i++)
        {
            for(int j = 0 ; j < thisMonth[i].length ; j++)
            {
                give[i] += thisMonth[i][j];
                receive[j] += thisMonth[i][j];
            }
        }
        
        for(int i = 0 ; i < N ; i++)
        {
            giftScore[i] = give[i] - receive[i];
        }
        
        for(int i = 0 ; i < thisMonth.length ; i++)
        {
            for(int j = i+1 ; j < thisMonth[i].length ; j++)
            {
                int itoj = thisMonth[i][j];
                int jtoi = thisMonth[j][i];
                if(itoj > jtoi)
                {
                    nextMonth[i]++;
                }
                else if(itoj < jtoi)
                {
                    nextMonth[j]++;
                }
                else
                {
                    if(giftScore[i] > giftScore[j]) nextMonth[i]++;
                    else if(giftScore[i] < giftScore[j]) nextMonth[j]++;
                }
            }
        }
        int answer = 0;
        for(int x: nextMonth)
        {
            answer = Math.max(answer, x);
        }
        return answer;
    }
}