import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] X = new int[N];
        for (int i = 0; i < N; i++)
        {
            X[i] = sc.nextInt();
        }
        
        int[] sortedX = X.clone();
        Arrays.sort(sortedX);
        
        Map<Integer, Integer> compressionMap = new HashMap<>();
        int rank = 0;
        
        for (int x : sortedX)
        {
            if (!compressionMap.containsKey(x)) {
                compressionMap.put(x, rank++);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int x : X)
        {
            sb.append(compressionMap.get(x)).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}
