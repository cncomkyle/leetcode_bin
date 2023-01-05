public class HeapSort {

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

        if(i * 2 < len && array[i * 2] > array[maxIndex]) {
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

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 8, 2, 9, 4};
        int[] newArray = HeapSort(array);

        for(int tmp : newArray) {
            System.out.println(tmp);
        }
    }

}

    
