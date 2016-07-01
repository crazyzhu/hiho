import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        int[] x = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt() - 1;
            x[i] = i;
            c[i] = -1;
        }
        int counter = 0;
        int ready = 0;
        while (ready != n) {
            counter++;
            for (int i = 0; i < n; i++) {
                if (c[i] == -1) {
                    x[i] = p[x[i]];
                    if (x[i] == i) {
                        c[i] = counter;
                        ready++;
                    }
                }
                
            }
        }        
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(c[i]);
        }
        int res = -1;
        for (Integer step : set) {
            if (res == -1) {
                res = step;
            } else {
                res = lcm(step, res);
            }
        }
        System.out.println(res);
    }
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    static int gcd(int a, int b) {
        if (a > b) {
            return gcd(b, a);
        }
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
