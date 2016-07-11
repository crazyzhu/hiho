import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T > 0) {
            System.out.println(solve(in));
            T--;        
        }
    }
    static int solve(Scanner in) {
        int n = in.nextInt(), m = in.nextInt();
        if (m >= n) {return 100;}
        int[] lostDays = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            lostDays[i] = in.nextInt();
        }
        lostDays[n + 1] = 101;
        int i = 0, j = m + 1, max = 0;
        while (j <= n + 1) {
            max = Math.max(lostDays[j] - lostDays[i] - 1, max);    
            i++;j++;
        }
        return max;
    }
}
