public class QuickSort {

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int getPivotIndex(int[] arr, int start, int end)
    {
        int pivot = arr[start];
        int swapIdx = start;

        for(int i = start + 1; i < arr.length; i++)
        {
            if (pivot > arr[i])
            {
                swapIdx++;
                swap(arr, swapIdx, i);
            }
        }
        swap(arr, swapIdx, start);

        return swapIdx;
    }

    static void quickSort(int[] arr, int left, int right)
    {
        if(left >= right)
        {
            return;
        }

        int pivotIndex = getPivotIndex(arr, left, right);

        quickSort(arr, left, pivotIndex-1);
        quickSort(arr, pivotIndex+1, right);
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 9, 1, 2, 5, 3};
        quickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
