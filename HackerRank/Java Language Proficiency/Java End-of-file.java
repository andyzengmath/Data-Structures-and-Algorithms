import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int line = 0;
        while (scan.hasNext()) {
            line++;
            System.out.println(line + " " + scan.nextLine());
        }
        
    }
}