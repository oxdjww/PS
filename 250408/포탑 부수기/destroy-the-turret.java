import java.io.*;
import java.util.*;

public class Main {
    private static Tower[][] board;
    private static int n;
    private static int m;
    private static int k;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new Tower[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = new Tower(
                    i, j,
                    Integer.parseInt(st.nextToken())
                );
            }
        }        

        for(int i = 0; i < k; i++) {
            int[] attacker = selectAttacker();
            // 최근 공격 저장
            board[attacker[0]][attacker[1]].attackHistory = i;
            System.out.println(attacker[0] + ", " + attacker[1]);
            // int[] victim = selectVictim();
            // attack(attacker, victim);
            // repair();
        }
    }

    private static int[] selectAttacker() {
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j].power != 0) {
                    min = Math.min(min, board[i][j].power);
                }
            }
        }

        List<Tower> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j].power != 0) {
                    if(board[i][j].power == min) {
                        list.add(board[i][j]);
                    }
                }                                       
            }
        }

        if(list.size() == 1) {
            // 1. 공격력 가장 낮은 포탑 (1개)
            return new int[]{list.get(0).x, list.get(0).y};
        } else {
            // 2. 가장 최근 공격
            Collections.sort(list, new Comparator<Tower>() {
                @Override
                public int compare(Tower t1, Tower t2) {
                    return Integer.compare(t2.attackHistory, t1.attackHistory);
                }
            });
            // 3. 행 열 합 가장 큰
            Collections.sort(list, new Comparator<Tower>() {
                @Override
                public int compare(Tower t1, Tower t2) {
                    return Integer.compare(t2.x + t2.y, t1.x + t2.y);
                }
            });
            // 4. 열 가장 큰
            Collections.sort(list, new Comparator<Tower>() {
                @Override
                public int compare(Tower t1, Tower t2) {
                    return Integer.compare(t2.y, t1.y);
                }
            });
            return new int[]{list.get(0).x, list.get(0).y};
        }
    }
}

class Tower {
    int x;
    int y;
    int power;
    int attackHistory;
    
    public Tower(int x, int y, int power) {
        this.x = x;
        this.y = y;
        this.power = power;
        this.attackHistory = 0;
    }
}