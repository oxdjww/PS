import java.io.*;
import java.util.*;

public class Main {
    private static int[][] stat;
    private static int min = Integer.MAX_VALUE;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stat = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, new ArrayList<>());
        System.out.println(min);
    }

    private static void dfs(int idx, List<Integer> team) {
        if (team.size() == n / 2) {
            List<Integer> other = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!team.contains(i))
                    other.add(i);
            }

            int s1 = calcStat(team);
            int s2 = calcStat(other);
            min = Math.min(min, Math.abs(s1 - s2));
            return;
        }

        for (int i = idx; i < n; i++) {
            team.add(i);
            dfs(i + 1, team);
            team.remove(team.size() - 1);
        }
    }

    private static int calcStat(List<Integer> team) {
        int sum = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = i + 1; j < team.size(); j++) {
                int a = team.get(i), b = team.get(j);
                sum += stat[a][b] + stat[b][a];
            }
        }
        return sum;
    }
}
