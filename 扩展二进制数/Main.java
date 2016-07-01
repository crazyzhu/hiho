import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res = run(in);
        System.out.println(res);
    }

    static int run(Scanner in) {
        int n = in.nextInt();
        int res = 1;
        for (int i = 1; i <= n / 2; i++) {
            if ((i & (n - (i<<1))) == 0) {
                res++;
            }
        }
        return res;
    }
}
