import java.io.*;
import java.util.*;

public class Main {
    private static Tower[][] board;
    private static int n;
    private static int m;
    private static int k;
    private static boolean[][] previousAttack;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new Tower[n][m];
        previousAttack = new boolean[n][m];
        visited = new boolean[n][m];
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
            if (attacker == null) break;
            // 공격자도 공격 관련에 포함
            previousAttack[attacker[0]][attacker[1]] = true;
            // 최근 공격 저장
            board[attacker[0]][attacker[1]].attackHistory = i;
            // 버프
            board[attacker[0]][attacker[1]].power += (n+m);
            // System.out.println(attacker[0] + ", " + attacker[1]);
            int[] victim = selectVictim(attacker);
            if (victim == null) break;

            // System.out.println(victim[0] + ", " + victim[1]);
            attack(attacker, victim);
            repair();
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                max = Math.max(max, board[i][j].power);
            }
        }
        System.out.println(max);
    }

    private static int[] selectAttacker() {
        int minPower = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j].power != 0) {
                    minPower = Math.min(minPower, board[i][j].power);
                }
            }
        }

        if(minPower == Integer.MAX_VALUE) return null;

        List<Tower> smallerPower = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j].power != 0) {
                    if(board[i][j].power == minPower) {
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
    } // selectAttacker()

    private static int[] selectVictim(int[] attacker) {
        int maxPower = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j].power != 0 && i != attacker[0] && j != attacker[1]) {
                    maxPower = Math.max(maxPower, board[i][j].power);
                }
            }
        }
        
        if(maxPower == Integer.MIN_VALUE) return null;

        List<Tower> biggestPower = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j].power != 0) {
                    if(board[i][j].power == maxPower && i != attacker[0] && j != attacker[1]) {
                        biggestPower.add(board[i][j]);
                    }
                }                                       
            }
        }

        if(biggestPower.size() == 1) {
            // 1. 공격력 가장 높은 포탑 (1개)
            return new int[]{biggestPower.get(0).x, biggestPower.get(0).y};
        } else {
            // 2. 가장 오래된 공격
            Collections.sort(biggestPower, new Comparator<Tower>() {
                @Override
                public int compare(Tower t1, Tower t2) {
                    return Integer.compare(t1.attackHistory, t2.attackHistory);
                }
            });
            int recentMin = biggestPower.get(0).attackHistory;
            List<Tower> recent = new ArrayList<>();
            for(int i = 0; i < biggestPower.size(); i++) {
                if(biggestPower.get(i).attackHistory == recentMin) {
                    recent.add(biggestPower.get(i));
                }
            }

            if(recent.size() == 1) {
                return new int[]{recent.get(0).x, recent.get(0).y};
            } else {
                // 3. 행 열 합 가장 작은
                Collections.sort(recent, new Comparator<Tower>() {
                    @Override
                    public int compare(Tower t1, Tower t2) {
                        return Integer.compare(t1.x + t1.y, t2.x + t2.y);
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
                    // 4. 열 가장 작은
                    Collections.sort(rowColSum, new Comparator<Tower>() {
                        @Override
                        public int compare(Tower t1, Tower t2) {
                            return Integer.compare(t1.y, t2.y);
                        }
                    });
                    return new int[]{rowColSum.get(0).x, rowColSum.get(0).y};
                }
            }
        }
    } // selectVictim()

    private static void attack(int[] attacker, int[] target) {
        visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        List<int[]> tmp = new ArrayList<>();
        tmp.add(new int[]{attacker[0], attacker[1]});
        Point start = new Point(attacker[0], attacker[1], tmp);
        queue.offer(start);
        visited[attacker[0]][attacker[1]] = true;
        Point shortestPathPoint = null;
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            // System.out.println("POLL " + current + ": " + cx + ", " + cy);
            if(cx == target[0] && cy == target[1]) {
                // 최단거리 탐색 완료
                shortestPathPoint = current;
                break;
            }
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 경계 벗어난다면 반대편으로
                if(nx < 0) nx = n-1;
                if(nx >= n) nx = 0;
                if(ny < 0) ny = m-1;
                if(ny >= m) ny = 0;
                if(board[nx][ny].power != 0 && !visited[nx][ny]) {
                    List<int[]> newPath = new ArrayList<>(current.path);
                    newPath.add(new int[]{nx, ny});
                    queue.offer(new Point(nx, ny, newPath));
                    visited[nx][ny] = true;

                    // System.out.println("OFFER " + input + ": " + nx + ", " + ny);
                    visited[nx][ny] = true;
                }
            }
        } // while
        // System.out.println("SHORTEST PATH");
        // if(shortestPathPoint != null ) {
        //         for(int i = 0 ; i < shortestPathPoint.path.size() ; i++) {
        //         System.out.print(shortestPathPoint.path.get(i)[0] + ", " + shortestPathPoint.path.get(i)[1]);
        //         System.out.println();
        //     }
        // }
        // System.out.println();
        if(shortestPathPoint == null) {
            // 포탄 공격
            // print();
            // System.out.println("POTAN");
            potanAttack(attacker, target);
            // print();
        } else {
            // 레이저 공격 로직
            // print();
            // System.out.println("LAZER");
            lazerAttack(attacker, shortestPathPoint);
            // print();
        }
    } // attack(int[], int[])
    private static void lazerAttack(int[] attacker, Point target) {
        // System.out.println("LAZER ATTACK");
        List<int[]> path = target.path;
        int attackerPower = board[attacker[0]][attacker[1]].power;

        for(int i = 0; i < path.size(); i++) {
            int x = path.get(i)[0];
            int y = path.get(i)[1];
            // System.out.println("LAZER :" + x + ", " + y);
            if(i == path.size() - 1) {
                // 공격지점
                // System.out.println(board[x][y].power + " -= " + attackerPower);
                int result = board[x][y].power - attackerPower;
                board[x][y].power = (result < 0 ? 0 : result);
            } else if(i != 0) {
                // 경로
                // System.out.println(board[x][y].power + " -= " + attackerPower/2);
                int result = board[x][y].power - attackerPower/2;
                board[x][y].power = (result < 0 ? 0 : result);
            }
            previousAttack[x][y] = true;
        }
    }
    private static void potanAttack(int[] attacker, int[] target) {
        // System.out.println("POTAN ATTACK");
        int attackPower = board[attacker[0]][attacker[1]].power;
        int targetX = target[0];
        int targetY = target[1];
        int targetAttackResult = board[targetX][targetY].power - attackPower;
        board[targetX][targetY].power = targetAttackResult < 0 ? 0 : targetAttackResult;
        previousAttack[targetX][targetY] = true;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int i = 0; i < dx.length; i++) {
            int nx = targetX + dx[i];
            int ny = targetY + dy[i];

            // 경계 벗어난다면 반대편으로
            if(nx < 0) nx = n - 1;
            if(nx >= n) nx = 0;
            if(ny < 0) ny = m - 1;
            if(ny >= m) ny = 0;

            // 자신은 제외
            if(nx == attacker[0] && ny == attacker[1]) continue;

            int result = board[nx][ny].power - attackPower/2;
            board[nx][ny].power = result < 0 ? 0 : result;
            previousAttack[nx][ny] = true;
        }
    }
    private static void print() {
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[i].length ; j++) {
                System.out.print(board[i][j].power + " ");
            }
            System.out.println();
        }
    }
    private static void repair() {
        // System.out.println("REPAIR");
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[i].length ; j++) {
                if(!previousAttack[i][j]) {
                    if(board[i][j].power != 0) {
                        board[i][j].power += 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(previousAttack[i], false);
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
class Point {
        int x;
        int y;
        List<int[]> path;
        public Point(int x, int y, List<int[]> path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }