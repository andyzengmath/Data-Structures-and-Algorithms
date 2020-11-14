public class Vector2D implements Iterator<Integer> {

    private List<List<Integer>> vector;
    private int inner = 0;
    private int outer = 0;

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        vector = vec2d;
    }
    private void advanceToNext() {
        while (outer < vector.size() && inner == vector.get(outer).size()) {
            inner = 0;
            outer++;
        }
    }

    @Override
    public Integer next() {
        // Write your code here
        if (!hasNext()) throw new NoSuchElementException();
        return vector.get(outer).get(inner++);
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        advanceToNext();
        return outer < vector.size();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */