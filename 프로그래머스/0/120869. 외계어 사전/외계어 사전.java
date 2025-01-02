class Solution {
    public int solution(String[] spell, String[] dic) {
        for(String word : dic)
        {
            int count = 0;
            for(String idx : spell)
            {
                if(word.contains(idx))
                    count++;
            }
            if(count == spell.length)
                return 1;
        }
        return 2;
    }
}