import java.util.*;
import java.util.Arrays; 

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        int n = segments.length;
        
        Arrays.sort(segments, new Comparator<Segment>() {
            public int compare(Segment s1, Segment s2) {
                return Integer.compare(s1.end, s2.end);
            }
        });

        int[] points = new int[segments.length];
        int numOfSeg = 1;
        int currEnd = segments[0].end;
        points[0] = segments[0].start;

        

        for (int i = 1; i < n ; i ++) {
            
            int currStart = segments[i].start;
            if (currEnd < currStart) {
                
                points[numOfSeg-1] = currEnd;
                numOfSeg += 1;
                currEnd = segments[i].end;
                
                
            }
           
        }
        points[numOfSeg - 1] = currEnd;

        int[] totalPoints = new int[numOfSeg];
        for (int i = 0; i < numOfSeg; i++) {
            totalPoints[i] = points[i];
        }

        return totalPoints;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
