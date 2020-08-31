import jdk.internal.jshell.tool.resources.l10n;

public class twoPointer {
    private int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n; int fast = getSum(n);
        while (slow != fast) {
            slow = getSum(slow);
            fast = getSum(fast);
            fast = getSum(fast);
            if (fast == 1) {
                return true;
            }
        }

        return slow == 1;
    }
}