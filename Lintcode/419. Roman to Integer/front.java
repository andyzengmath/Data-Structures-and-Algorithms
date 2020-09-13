class front {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int sum = 0;
        int prenum = getValue(s.charAt(0));    
        int length = s.length();
        
        for (int i = 1; i < length; i++) {
            int num = getValue(s.charAt(i));
            if (prenum < num) {
                sum -= prenum;
            } else {
                sum += prenum;
            }
            prenum = num;
        }
        sum += prenum;
        return sum;
        
    }
    
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}