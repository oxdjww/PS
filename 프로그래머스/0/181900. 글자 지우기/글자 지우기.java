class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder(my_string);
        for(int i = 0 ; i < indices.length ; i++)
        {
            sb.setCharAt(indices[i], '0');
        }
        return sb.toString().replaceAll("0", "");
    }
}