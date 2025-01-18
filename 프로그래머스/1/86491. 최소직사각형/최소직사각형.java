import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int[] widths = new int[sizes.length];
        int[] heights = new int[sizes.length];
        int max = calculateMax(widths, heights);
        
        for(int i = 0 ; i < widths.length ; i++)
        {
            widths[i] = Math.max(sizes[i][0], sizes[i][1]);
            heights[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        return calculateMax(widths, heights);
    }
    private int calculateMax(int[] widths, int[] heights)
    {
        int widthMax = Arrays.stream(widths).max().getAsInt();
        int heightMax = Arrays.stream(heights).max().getAsInt();
        return widthMax * heightMax;
    }
}