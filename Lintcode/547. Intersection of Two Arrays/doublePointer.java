public class doublePointer {
    // O(mlog(m) + nlog(n)), O(m+n), O(1)
    // 
    Array.sort(nums1);
    Array.sort(nums2);

    int i = 0, j = 0;
    Set<Integer> intersect = new HashSet<>();
    while (i < nums1[i].length && j < nums2.length) {
        if (nums1[i] < num2[j]) {
            i++;
        } else if (num1[i] > nums2[j]) {
            j++;
        } else {
            intersect.add(nums1[i]);
            i++;
            j++;
        }
    }

    int[] result = new int [intersect.size()];
    int index = 0;
    for (int num: intersect) {
        result[index++] = num;
    }

    return result;
}