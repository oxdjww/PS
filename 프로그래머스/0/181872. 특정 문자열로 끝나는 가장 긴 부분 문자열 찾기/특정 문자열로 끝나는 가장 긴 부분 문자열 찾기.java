class Solution {
    public String solution(String myString, String pat) {
        int end = 0;
        for(int i = 0 ; i < myString.length() ; i++)
        {
            String part = myString.substring(0, i+1);
            if (part.endsWith(pat))
                end = i;
        }
        return myString.substring(0,end+1);
    }
}