import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        int n = segments.length;
        int[] points = new int[segments.length];
        int numOfSeg = 1;
        currEnd = segments[0].end;

        Array.sort(segments, new Comparator<Segment>() {
            public int compare(Segment s1, Segment s2) {
                return Integer.compare(s1.end, s2.end);
            }
        });

        for (int i = 1; i < n ; i ++) {
            
            currStart = segment[i].start;
            if (currEnd < currStart) {
                numOfSeg += 1;
                points.add(currEnd);
                numOfSeg +=1;
            }
        }
        int[] totalPoints = new int[j];
        for (int i = 0; i < segments.length; i++) {
            totalPoints[i] = points[i];
        }
        return points;
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
 
