import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int res = a;
            for (int k = 0; k < n; k++) {
                res += (1 << k) * b;
                if (k > 0) System.out.print(" ");
                System.out.printf("%d", res);
            }
            System.out.printf("\n");
        }
        in.close();
    }
}