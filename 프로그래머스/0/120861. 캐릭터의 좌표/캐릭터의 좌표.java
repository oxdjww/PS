class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int xlimit = board[0]/2;
        int ylimit = board[1]/2;
        int x = 0;
        int y = 0;
        for(String cmd : keyinput)
        {
            switch(cmd){
                case "left":
                    if(x != (-1 * xlimit))
                        x--;
                    break;
                case "right":
                    if(x != xlimit)
                        x++;
                    break;
                case "up":
                    if(y != ylimit)
                        y++;
                    break;
                case "down":
                    if(y != (-1 * ylimit))
                        y--;
                    break;
                default:
                    break;
            }
        }
        return new int[]{x, y};
    }
}