import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        Queue<Word> q = new LinkedList<>();
        
        q.offer(new Word(begin, 0));
        while(!q.isEmpty())
        {
            Word cur = q.poll();
            if(cur.value.equals(target)) return cur.count;
            
            for(int i = 0 ; i < words.length ; i++)
            {
                if(!visited[i] && isOneCharDifferent(cur.value, words[i]))
                {
                    System.out.println("PUT: "+words[i]);
                    visited[i] = true;
                    q.offer(new Word(words[i], cur.count + 1));
                }
            }
        }
        
        return 0;
    }
    public static boolean isOneCharDifferent(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int diff = 0;
        for(int i = 0; i < s1.length() && diff < 2; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
class Word {
    String value;
    int count;
    Word(String value, int count)
    {
        this.value = value;
        this.count = count;
    }
}
