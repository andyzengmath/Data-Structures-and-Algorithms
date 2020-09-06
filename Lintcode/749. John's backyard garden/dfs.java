public class dfs {
    public String isBuild(int x) {
        if (trueOrFalse(x)) return "YES";
        return "NO";
    }

    private boolean trueOrFalse(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        return trueOrFalse(x - 3) || trueOrFalse(x - 7)''
    }
}