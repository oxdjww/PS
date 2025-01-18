import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visit = new boolean[n][m];
        visit[0][0] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));
        
        while(!q.isEmpty())
        {
            Node cur = q.poll();
            if(cur.posX == n - 1 && cur.posY == m - 1)
                return cur.cnt;
            
            if(cur.posX < n - 1 && maps[cur.posX + 1][cur.posY] == 1 && visit[cur.posX + 1][cur.posY] != true)
            {
                visit[cur.posX + 1][cur.posY] = true;
                q.offer(new Node(cur.posX + 1, cur.posY, cur.cnt + 1));
            }
            if(cur.posX > 0 && maps[cur.posX - 1][cur.posY] == 1 && visit[cur.posX - 1][cur.posY] != true)
            {
                visit[cur.posX - 1][cur.posY] = true;
                q.offer(new Node(cur.posX - 1, cur.posY, cur.cnt + 1));
            }
            if(cur.posY < m - 1 && maps[cur.posX][cur.posY + 1] == 1 && visit[cur.posX][cur.posY + 1] != true)
            {
                visit[cur.posX][cur.posY + 1] = true;
                q.offer(new Node(cur.posX, cur.posY + 1, cur.cnt + 1));
            }
            if(cur.posY > 0 && maps[cur.posX][cur.posY - 1] == 1 && visit[cur.posX][cur.posY - 1] != true)
            {
                visit[cur.posX][cur.posY - 1] = true;
                q.offer(new Node(cur.posX, cur.posY - 1, cur.cnt + 1));
            }
        }
        return -1;
    }
}
class Node {
    int posX;
    int posY;
    int cnt;
    
    Node(int posX, int posY, int cnt)
    {
        this.posX = posX;
        this.posY = posY;
        this.cnt = cnt;
    }
}