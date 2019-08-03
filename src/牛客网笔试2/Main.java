package 牛客网笔试2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
            while (data[i] % 2 == 0) {
                data[i] = data[i] / 2;
            }
        }
        int flag = data[0];
        for (int i = 1; i < n; i++) {
            if (data[i] != flag) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
