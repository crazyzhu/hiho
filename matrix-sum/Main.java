import java.util.*;

public class Main {
    private static final int base = 1000000000 + 7;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] sumMatrix = new int[n][n+1];
        for (; m > 0; m--) {
            String op = in.next();
            if (op.equals("Add")) {
                int x = in.nextInt(), y = in.nextInt(), val = in.nextInt();
                for (int j = y + 1; j <= n; j++) {
                    sumMatrix[x][j] = (sumMatrix[x][j] + val) % base;
                }
            } else {
                int x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
                int tmp = 0;
                for (int i = x1; i <= x2; i++) {
                    tmp = (tmp + ((sumMatrix[i][y2 + 1] - sumMatrix[i][y1]) % base)) % base;
                }
                System.out.println(tmp < 0 ? tmp + base : tmp);
            }
        }
    }
}
