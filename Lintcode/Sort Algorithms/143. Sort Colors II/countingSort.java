public class countingSort {
    public void sortColors2(int[] colors, int k) {
        int len = colors.length;
        if (len <= 1 || k <= 1) {
            return;
        }

        int index = 0;
        while (index < len) {
            int temp = color[index] - 1;
            if (colors[index] <= 0) {
                index ++;
            } else {
                if (colors[temp] <= 0) {
                    colors[temp] --;
                    colors[index] = 0;
                    index ++;
                } else {
                    swap(colors[index], colors[temp]);
                    colors[temp] = -1;
                }
            }
        }
    }

    public void swap (int[] colors, a, b) {
        int temp = colors[a];
        colors[a] = colors[b];
        colors[b] = temp;
    }
}