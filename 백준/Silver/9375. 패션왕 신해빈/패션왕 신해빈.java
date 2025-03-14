import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++)
        {
            int n = sc.nextInt();
            sc.nextLine();

            Map<String, Integer> clothes = new HashMap<>();
            
            for (int j = 0; j < n; j++)
            {
                String[] input = sc.nextLine().split(" ");
                String clothingName = input[0];
                String clothingType = input[1];

                clothes.put(clothingType, clothes.getOrDefault(clothingType, 0) + 1);
            }

            int result = 1;
            for (int count : clothes.values())
            {
                result *= (count + 1);
            }

            result -= 1;

            System.out.println(result);
        }
    }
}
