// V1:双重检查+synchronized锁懒汉版
public class Solution {
    // 1. 私有单例对象，禁止通过 类名.属性 访问
    // 2. 将其声明为静态成员，使得在静态方法中得以访问
    // 3. 使用volatile关键字，消除指令重排序的影响
    public static Solution getInstance() {
        if (instance == null) {
            synchronized(Solution.class) {
                if (instance == null) {
                    instance = new Solution();
                    // 多线程并发访问，只会有一个线程初始化成功
                }
            }
        }
        return instance;
    }
}

// V2: 静态内部类版
public class Solution {
    static class InnerClass {
        private static Solution instance = new Solution();
    }
    public static Solution getInstance() {
        return Solution.instance;
    }
}

// V3: 枚举类版
public enum Solution {
    INSTANCE;

    public static Solution getInstance() {
        return Solution.INSTANCE;
    }
}