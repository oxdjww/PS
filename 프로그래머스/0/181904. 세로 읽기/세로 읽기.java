class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        char[] arr = my_string.toCharArray();
        for(int i = c-1 ; i < arr.length ; i+=m)
        {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}