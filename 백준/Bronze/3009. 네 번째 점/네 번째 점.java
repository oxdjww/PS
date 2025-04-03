import java.util.*;
import java.io.*;

public class Main {
    private static HashSet<Integer> ahs = new HashSet<>();
    private static HashSet<Integer> bhs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0 ; i < 3 ; i ++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(ahs.contains(a)) {
                ahs.remove(a);
            } else {
                ahs.add(a);
            }

            if(bhs.contains(b)) {
                bhs.remove(b);
            } else {
                bhs.add(b);
            }
        }
        System.out.print(ahs.toArray()[0] + " " + bhs.toArray()[0]);
    }
}