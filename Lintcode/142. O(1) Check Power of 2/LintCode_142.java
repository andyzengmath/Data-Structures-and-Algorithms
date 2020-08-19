public class LintCode_142 {
    /**
     * @param n: An integer
     * @return: True or false
     * 2的幂的数字，其二进制中只有一个1。 n&(n-1) == 0 说明只有1个1。
     * 2的次幂的二进制表达有个特点，即只有一位是1
     * 所以如果一个整数的二进制只有一个数位是1它就是2的次幂，那怎么判断整数的二进制只有一个数位是1呢？
     * 可以发现，若整数n是2的次幂，则n减1再与n &运算后值为0 :
     * 2 = (10)2 —-> 1 = (01)2
     * 4 = (100)2 —-> 3 = (011)2
     * 8 = (1000)2 —-> 7 = (0111)2

     与运算：
     0&0=0；0&1=0；1&0=0；1&1=1
     即：两个同时为1，结果为1，否则为0

     *
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if (n <= 0) {
            return false;
        } else if (n <= 2) {
            return true;
        }
        return (n & (n - 1)) == 0;
    }
}