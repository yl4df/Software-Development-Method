// LAB 9: Recursion, Pt. 1

public class MaxMin {

    public static void main(String[] args) {
        int[] values = { 19, 12, 13, 14, 17, 18, 16, 14, 11 };
        int[] maxMinResults = maxMin(values, 0, values.length - 1);
        System.out.println(maxMinResults[0] + " and " + maxMinResults[1]);
    }

    /*
     * maxMin() - Return an array containing the minimum and maximum values of the input array.
     * @param list: an array of ints as input
     * @param first: the first index of the list (for recursion)
     * @param last: the last index of the list (for recursion) Identify a base case, and work it out so that the array
     * returns the min and max values. Then, identify what the method does to recursively arrive at the base case.
     * @return: an int array, one index is minimum and the other is the maximum value.
     */
    public static int[] maxMin(int[] list, int first, int last) {
        int[] result = new int[2];
        int localmin, localmax;
        int max1, max2, min1, min2, mid;
        if (first == last) {
            localmin = list[first];
            localmax = list[first];
        } else {

            mid = (first + last) / 2;
            int[] result1 = maxMin(list, first, mid);
            int[] result2 = maxMin(list, mid + 1, last);

            max1 = result1[0];
            min1 = result1[1];
            max2 = result2[0];
            min2 = result2[1];

            if (max1 < max2)
                localmax = max2;
            else
                localmax = max1;

            if (min1 < min2)
                localmin = min1;

            else
                localmin = min2;

        }
        result[0] = localmax;
        result[1] = localmin;
        return result;
    }
}
