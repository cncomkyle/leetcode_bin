public class Solution {


    public static int[] bubbleSort(int[] array) {
        if(array.length == 0) {
            return array;
        }

        for(int i=0;i<array.length;i++) {
            for(int j=0;j< array.length - 1 - i;j++) {
                if(array[j+1] < array[j]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }


    public static int[] selectionSort(int[] array) {
        if(array.length==0) {
            return array;
        }

        for(int i=0;i<array.length;i++) {
            int minIndex = i;
            for(int j=i;j<array.length;j++) {
                if(array[j]<array[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }

        return array
    }


    public static int[] insertionSort(int[] array) {
        if(array.length==0) {
            return array;
        }

        int current;
        for(int i=0;i< array.length-1;i++) {
            current = array[i+1];
            int preIndex = i;
            while(preIndex >=0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }

            array[preIndex+1] = current;
        }

        return array;
    }


    public static int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while(gap > 0) {
            for(int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while(preIndex >=0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }

                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public static int[] mergeSort(int[] array) {
        if(array.length < 2) return array;

        int mid = array.length / 2;

        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        for(int index=0, i=0, j=0;indext < result.length; index++) {
            if(i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
    }


    public static int[] QuickSort(int[] array, int start, int end) {
        if(array.length < 1 || start < 0 || end >= array.length || start > end) return null;

        int smallIndex = partition(array, start, end);
        if(smartIndex > start) {
            QuickSort(array, start, smallIndex - 1);
        }
        if(smalllIndex < end) {
            QuickSort(array, smallIndex + 1, end);
        }

        return array;
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for(int i = start;i<=end;i++) {
            if(array[i] <= array[end]) {
                smallIndex++;
                if(i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    public static void swap(int[]array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    static int len;

    public static int[] HeapSort(int[] array) {
        len = array.length;
        if(len < 1) return array;

        buildMaxHeap(array);

        while(len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }

        return array;
    }


    public static void buildMaxHeap(int[] array) {
        for(int i=(len/2 -1);i>=0;i--) {
            adjustHeap(array, i);
        }
    }

    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;

        if(i * 2 < len && aray[i * 2] > array[maxIndex]) {
            maxIndex = i * 2;
        }
        if(i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
            maxIndex = i * 2 + 1;
        }

        if(maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    
    
}
