import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String answer = "";
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 0 && b == 0 && c == 0) {
                return;
            }

            if(a == b && b == c) {
                answer = "Equilateral";
            } else if (a == b || b == c || c == a) {
                answer = "Isosceles";
            } else if (a != b && b != c && c != a) {
                answer = "Scalene";
            }
            long longest = Math.max(c, Math.max(a, b));
            long remain = a + b + c - longest;
            if(longest >= remain){
                answer = "Invalid";
            }
            System.out.println(answer);
        }        
    }
}

