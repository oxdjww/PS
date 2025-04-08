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

        for(int i = 1; i <= k; i++) {
            int[] attacker = selectAttacker();
            // 최근 공격 저장
            board[attacker[0]][attacker[1]].power = 4;
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

        List<Tower> smallerPower = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j].power != 0) {
                    if(board[i][j].power == min) {
                        smallerPower.add(board[i][j]);
                    }
                }                                       
            }
        }

        if(smallerPower.size() == 1) {
            // 1. 공격력 가장 낮은 포탑 (1개)
            return new int[]{smallerPower.get(0).x, smallerPower.get(0).y};
        } else {
            // 2. 가장 최근 공격
            Collections.sort(smallerPower, new Comparator<Tower>() {
                @Override
                public int compare(Tower t1, Tower t2) {
                    return Integer.compare(t2.attackHistory, t1.attackHistory);
                }
            });
            int recentMin = smallerPower.get(0).attackHistory;
            List<Tower> recent = new ArrayList<>();
            for(int i = 0; i < smallerPower.size(); i++) {
                if(smallerPower.get(i).attackHistory == recentMin) {
                    recent.add(smallerPower.get(i));
                }
            }

            if(recent.size() == 1) {
                return new int[]{recent.get(0).x, recent.get(0).y};
            } else {
                // 3. 행 열 합 가장 큰
                Collections.sort(recent, new Comparator<Tower>() {
                    @Override
                    public int compare(Tower t1, Tower t2) {
                        return Integer.compare(t2.x + t2.y, t1.x + t1.y);
                    }
                });
                int rowColSumMax = recent.get(0).x + recent.get(0).y;
                List<Tower> rowColSum = new ArrayList<>();
                for(int i = 0; i < recent.size(); i++) {
                    if(recent.get(i).x + recent.get(i).y == rowColSumMax) {
                        rowColSum.add(recent.get(i));
                    }
                }
                                    
                if(rowColSum.size() == 1) {
                    return new int[]{rowColSum.get(0).x, rowColSum.get(0).y};
                } else {
                    // 4. 열 가장 큰
                    Collections.sort(rowColSum, new Comparator<Tower>() {
                        @Override
                        public int compare(Tower t1, Tower t2) {
                            return Integer.compare(t2.y, t1.y);
                        }
                    });
                    return new int[]{rowColSum.get(0).x, rowColSum.get(0).y};
                }
            }
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