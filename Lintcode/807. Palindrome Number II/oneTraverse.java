public class oneTraverse(int n) {
    public boolean isPalindrome(int n) {
        //一次循环，记录n 的reverse 返回n是否等于reverse
        if (n < 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int compo = 0;
        int copy = n;
        while (copy != 0) {
            compo *= 2;
            compo += copy % 2 == 1 ? 1 : 0;
            copy /= 2;
        }
        return compo == n;
    }
}