import java.util.Random;

public class MergeSort {

    public int[] mergeSort(int[] arr) {
        // Base Case to stop recursion when leaf nodes are reached
        if (arr.length <= 1) {
            return arr;
        }
        int midIndex = arr.length / 2;
        // Initialize left and right arrays based on arr size
        int[] lArray = new int[midIndex];
        int[] rArray;
        if (arr.length % 2 == 0) {
            rArray = new int[midIndex];
        } else {
            rArray = new int[midIndex + 1];
        }
        // Populate both left and right array
        for (int i = 0; i < midIndex; i++) {
            lArray[i] = arr[i];
        }
        for (int j = 0; j < rArray.length ; j++) {
            rArray[j] = arr[midIndex + j];
        }
        int[] result;
        // Recursive step
        lArray = mergeSort(lArray);
        rArray = mergeSort(rArray);
        result = mergeHalves(lArray, rArray);
        return result;
    }

    public int[] mergeHalves(int[] leftArr, int[] rightArr) {
        int[] c = new int[leftArr.length + rightArr.length];
        int lPtr = 0, cPtr = 0, rPtr = 0;
        // 3 Pointers for each array
        if (leftArr.length != 0 && rightArr.length != 0) {
            while (lPtr < leftArr.length && rPtr < rightArr.length) {
                // Push the smaller element between each array's pointer
                if (leftArr[lPtr] < rightArr[rPtr]) {
                    c[cPtr] = leftArr[lPtr];
                    lPtr++;
                } else {
                    c[cPtr] = rightArr[rPtr];
                    rPtr++;
                }
                cPtr++;
            }
            // Copy over the remaining array elements if any
            if (lPtr < leftArr.length) {
                while (lPtr < leftArr.length) {
                    c[cPtr] = leftArr[lPtr];
                    cPtr++;
                    lPtr++;
                }
            } else if (rPtr < rightArr.length) {
                while (rPtr < rightArr.length) {
                    c[cPtr] = rightArr[rPtr];
                    rPtr++;
                    cPtr++;
                }
            }
        }

        return c;
    }

}
