public class Subarray {
    public static void main(String[] args) {
        for (int in : subArray(new int[]{1, 2, 3, 7, 5}, 12)) {
            System.out.print(in + " ");
        }
    }

    static int[] subArray(int[] a, int k) {
        int start = 0, end = 0, sum = a[end];
        for (int i = 0; i < 2 * a.length; i++) {
            if (sum == k) {
                return new int[]{start, end};
            } else if (sum < k && end < a.length - 1) {
                end++;
                sum += a[end];
            } else if (sum > k && start < end) {
                sum -= a[start];
                start++;
            } else if (sum > k && start == end && end < a.length - 1) {
                start++;
                end++;
                sum = a[end];
            }
        }
        return new int[]{-1, -1};
    }
}
