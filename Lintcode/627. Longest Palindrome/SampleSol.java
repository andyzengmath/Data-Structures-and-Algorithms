public class SampleSol {
    public int SampleSol(String s){
        int[] count = new int[52];
        int oddCount = 0;
        int answer = 0;

        for (char c: s.toCharArray()){
            if (c > 97) {
                count[26 + c - 'a'] ++;
            } else {count[c - 'A'] ++;
            }
        }

        for (int i = 0; i < 52; i++) {
            answer += count[i]/2*2;
            if (count[i] % 2 == 1){
                oddCount = 1;
            }
        }

        return answer += oddCount;
    }
}