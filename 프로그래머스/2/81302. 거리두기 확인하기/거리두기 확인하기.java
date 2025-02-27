import java.util.*;

class Solution
{
    public int[] solution(String[][] places)
    {
        int[] answer = new int[places.length];
        for(int i=0;i<places.length;i++)
        {
            if(checkPlace(places[i])) answer[i]=1;
            else answer[i]=0;
        }
        return answer;
    }

    private boolean checkPlace(String[] place)
    {
        char[][] board=new char[5][5];
        for(int r=0;r<5;r++)
        {
            for(int c=0;c<5;c++)
            {
                board[r][c]=place[r].charAt(c);
            }
        }
        for(int r=0;r<5;r++)
        {
            for(int c=0;c<5;c++)
            {
                if(board[r][c]=='P')
                {
                    if(!checkManhattan(board,r,c)) return false;
                }
            }
        }
        return true;
    }

    private boolean checkManhattan(char[][] board,int r,int c)
    {
        int[] dx1={-1,1,0,0};
        int[] dy1={0,0,-1,1};
        for(int i=0;i<4;i++)
        {
            int nr=r+dx1[i];
            int nc=c+dy1[i];
            if(inRange(nr,nc)&&board[nr][nc]=='P') return false;
        }
        int[] dx2={-2,2,0,0};
        int[] dy2={0,0,-2,2};
        for(int i=0;i<4;i++)
        {
            int nr=r+dx2[i];
            int nc=c+dy2[i];
            if(inRange(nr,nc)&&board[nr][nc]=='P')
            {
                int mr=(r+nr)/2;
                int mc=(c+nc)/2;
                if(board[mr][mc]!='X') return false;
            }
        }
        int[] diagR={-1,-1,1,1};
        int[] diagC={-1,1,-1,1};
        for(int i=0;i<4;i++)
        {
            int nr=r+diagR[i];
            int nc=c+diagC[i];
            if(inRange(nr,nc)&&board[nr][nc]=='P')
            {
                if(board[r][nc]!='X'||board[nr][c]!='X') return false;
            }
        }
        return true;
    }

    private boolean inRange(int r,int c)
    {
        return r>=0&&r<5&&c>=0&&c<5;
    }
}
