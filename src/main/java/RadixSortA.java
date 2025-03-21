import java.util.ArrayList;
import java.util.Arrays;

public class RadixSortA {
    public static void main(String[] args) {
        String[] strings = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo", "pupperino", "amaterasu", "amazon", "puppy", "hydra", "amazonia", "vueltiao"};
        System.out.println("UNSORTED: " + Arrays.toString(strings));
        radixSort(strings);
        System.out.println("SORTED:   " + Arrays.toString(strings));

        String[] strings2 = {"abate", "Bookend", "Apple", "bake"};
        System.out.println("UNSORTED: " + Arrays.toString(strings2));
        radixSort(strings2);
        System.out.println("SORTED:   " + Arrays.toString(strings2));
    }

    private static int getMaxLetters(String[] arr) {
        int max = arr[0].length();
        for (String str : arr) {
            if (str.length() > max) {
                max = str.length();
            }
        }
        return max;
    }

    private static void radixSort(String[] arr) {
        ArrayList<ArrayList<String>> buckets = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 53; i++) {
            buckets.add(new ArrayList<String>());
        }
        int copyBackIndex = 0, bucketIndex = 0;
        int maxLetters = getMaxLetters(arr);
        for (int letter = maxLetters - 1; letter >= 0; letter--) {
            for (String str : arr) {
                if (letter >= str.length()) {
                    buckets.get(0).add(str);
                    continue;
                }
                bucketIndex = str.charAt(letter);
                if (bucketIndex >= 'A' && bucketIndex <= 'Z') {
                    bucketIndex -= 64;
                    bucketIndex += bucketIndex - 1;
                } else if (bucketIndex >= 'a' && bucketIndex <= 'z') {
                    bucketIndex -= 96;
                    bucketIndex *= 2;
                }
                buckets.get(bucketIndex).add(str);
            }
            copyBackIndex = 0;
            for (int i = 0; i < 53; i++) {
                ArrayList<String> bucket = buckets.get(i);
                for (String s : bucket) {
                    arr[copyBackIndex] = s;
                    copyBackIndex++;
                }
                bucket.clear();
            }
        }
    }
}