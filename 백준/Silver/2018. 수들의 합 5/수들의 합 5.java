import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;

        for (int k = 1; k * (k - 1) < 2 * N; k++) {
            if ((2 * N - k * (k - 1)) % (2 * k) == 0) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
