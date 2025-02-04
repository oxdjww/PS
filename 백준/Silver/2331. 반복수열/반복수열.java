import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int P = scanner.nextInt();
        scanner.close();

        System.out.println(findSequenceLength(A, P));
    }
    
    
    private static int getNextNumber(int num, int P) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, P);
            num /= 10;
        }
        return sum;
    }

    private static int findSequenceLength(int A, int P) {
        Map<Integer, Integer> sequenceIndex = new HashMap<>();
        int index = 0;
        int current = A;

        while (!sequenceIndex.containsKey(current)) {
            sequenceIndex.put(current, index);
            current = getNextNumber(current, P);
            index++;
        }
        return sequenceIndex.get(current);
    }
}