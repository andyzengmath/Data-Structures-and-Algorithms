/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

      public class LintCode_660 extends Reader4 {
        /**
         * @param buf destination buffer
         * @param n maximum number of characters to read
         * @return the number of characters read
         */
        int readI = 0, writeI = 0;
        char[] buff = new char[4];
        public int read(char[] buf, int n) {
            // Write your code here
            for (int i = 0; i < n; i++) {
                if (readI == writeI){
                    writeI = read4(buff);
                    readI = 0;
                    if (writeI == 0) return i;
                } 
                buf[i] = buff[readI++];
            }
            return n;
        }
    }