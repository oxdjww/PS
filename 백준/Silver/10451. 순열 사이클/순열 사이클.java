import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0)
        {
            int N = sc.nextInt();
            int[] permutation = new int[N + 1]; 
            for(int i = 1; i <= N; i++){
                permutation[i] = sc.nextInt();
            }

            boolean[] visited = new boolean[N + 1];
            int cycleCount = 0;

            for(int i = 1; i <= N; i++)
            {
                if(!visited[i])
                {
                    cycleCount++;
                    
                    int current = i;
                    while(!visited[current])
                    {
                        visited[current] = true;
                        current = permutation[current];
                    }
                }
            }

            System.out.println(cycleCount);
        }

        sc.close();
    }
}
