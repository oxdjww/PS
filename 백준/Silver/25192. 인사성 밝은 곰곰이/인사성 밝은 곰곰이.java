import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        HashSet<String> hs = new HashSet<>();
        int count = 0;
        for(int i = 0 ; i < n ; i++)
        {
            String msg = sc.next();

            if(msg.equals("ENTER"))
            {
                hs.clear();
            }
            else
            {
                if(!hs.contains(msg))
                {
                    hs.add(msg);
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
