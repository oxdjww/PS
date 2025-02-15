import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++)
            {
                System.out.print(" ");
            }

            for (int j = 0; j < i*2-1; j++)
            {
                if(i == N) System.out.print("*");
                else if(j == 0 || j == i*2-2) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
