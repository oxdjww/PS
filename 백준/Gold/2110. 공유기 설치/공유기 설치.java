import java.util.*;
import java.io.*;

public class Main {
    private static int[] houses;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        houses = new int[n];

        for(int i = 0 ; i < n ; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int left = 0;
        int right = houses[n-1] - houses[0];

        int maxDistance = 0;
        while(left <= right) {
            int mid = (right + left)/2;

            if(canInstall(mid, c)) {
                maxDistance = mid;
                left = ++mid;
            } else {
                right = --mid;
            }
        }
        System.out.print(maxDistance);
    }
    private static boolean canInstall(int distance, int c) {
        int count = 1;
        int recent = houses[0];

        for(int i = 1 ; i < houses.length ; i++) {
            if(houses[i] - recent >= distance) {
                count++;
                recent = houses[i];
            }
        }
        
        return count >= c;
    }
}