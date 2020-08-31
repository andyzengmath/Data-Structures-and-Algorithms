import java.util.List;

public class LinkedList {
    List<Integer> data = new LinkedList<>();

    public void push(int x) {
        data.add(0, x);
    }

    public void pop() {
        if (data.isEmpty()) {
            return;
        } else {
            data.remove(0);
        }
    }

    public int top() {
        return data.get(0);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}