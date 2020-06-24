import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numStops = stops.length;
        int numFills = 0;
        int currFill = 0;
        int lastFillValue = 0;


        if (dist- stops[numStops -1] > tank) {
            return -1;
        }

        while (currFill < numStops) {
            int lastFill = currFill;

            while (currFill < numStops && stops[currFill] - lastFillValue <= tank) {
                currFill = currFill + 1;
            }
            //System.out.print(currFill);
            //System.out.println("fill");

            if (currFill == lastFill) {
                return -1;
            }
            if (dist - lastFillValue <= tank) {
                return numFills;
            }

            if (currFill <= numStops) {
                lastFillValue = stops[currFill - 1];
                numFills += 1;
                }
                
            }
          

        if (dist - lastFillValue > tank) {
            return -1;
        } else {
            return numFills;
        }
        
    
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
