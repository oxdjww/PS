class Solution {
    public int solution(String myString, String pat) {
        int count = 0;
        for(int i = 0 ; i < myString.length() ; i++)
        {
            String part = myString.substring(0, i+1);
            if (part.endsWith(pat))
                count++;
        }
        return count;
    }
}