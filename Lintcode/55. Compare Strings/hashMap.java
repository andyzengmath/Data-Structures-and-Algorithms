public class hashMap {
    public boolean compareStrings(String A, String B) {
        if (A == null || B == null || A.length() < B.length()) {
            return false;
        }

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            String key = String.valueOf(A.charAt(i));
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
                continue;
            }
            hashMap.put(key, 1);
        }

        for (int j = 0; j < B.length(); j++) {
            if (!hashmap.containsKey(key)) {
                return false;
            } else {
                hashMap.put(key, hashMap.get(key) - 1);
            }
        }

        for (Integer value: hashMap.values()) {
            if (value < 0) {
                return false;
            }
        }

        return true;
    }
}