import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        System.out.println(compute(exp));
    }
    static int compute(String exp) {
        while ((exp = exp.trim()).charAt(0) == '(' && exp.charAt(exp.length() - 1) == ')') {
            exp = exp.substring(1, exp.length() - 1);
        }
        int leftBracketCount = 0;
        int opPos = -1;
        boolean opSign = false;
        for (int i = 0; i < exp.length(); i++) {
            switch(exp.charAt(i)) {
                case '(':
                    leftBracketCount++;
                    break;
                case ')':
                    leftBracketCount--;
                    break;
                case '*':
                case '/':
                    if (leftBracketCount == 0 && opPos == -1) {
                        opPos = i;
                        opSign = true;
                    }
                    break;
                case '+':
                case '-':
                    if (leftBracketCount == 0 && (opPos == -1 || opSign)) {
                        opPos = i;
                        opSign = false;
                    }
                    break;
                default:
            }
        }
        if (opPos == -1) {
            return Integer.valueOf(exp);
        } else {
            int left = compute(exp.substring(0, opPos));
            int right = compute(exp.substring(opPos + 1, exp.length()));
            switch (exp.charAt(opPos)) {
                case '+':
                    return left + right;
                case '-':
                    return left - right;
                case '*':
                    return left * right;
                default:
                    return left / right;
            }
        }

    }
}
