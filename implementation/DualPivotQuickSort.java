public class DualPivotQuickSort {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] getPivotIndex(int[] arr, int start, int end)
    {
        if(arr[start] > arr[end])
            swap(arr, start, end);

        int swapIdxStart = start + 1;
        int swapIdxEnd = end - 1;
        int i = start + 1;
        int pivotStart = arr[start];
        int pivotEnd = arr[end];

        while(i <= swapIdxEnd)
        {
            if(pivotStart > arr[i])
            {
                swap(arr, i, swapIdxStart);
                swapIdxStart++;
            }
            else if(arr[i] >= pivotEnd)
            {
                while(arr[swapIdxEnd] > pivotEnd && i < swapIdxEnd)
                    swapIdxEnd--;

                swap(arr, i, swapIdxEnd);
                swapIdxEnd--;

                if (arr[i] < pivotStart)
                {
                    swap(arr, i, swapIdxStart);
                    swapIdxStart++;
                }
            }
            i++;
        }
        swapIdxStart--;
        swapIdxEnd++;

        swap(arr, start, swapIdxStart);
        swap(arr, end, swapIdxEnd);

        return new int[] { swapIdxStart, swapIdxEnd };
    }

    static void dualPivotQuickSort(int[] arr, int left, int right)
    {
        if(left < right)
        {
            int[] piv;
            piv = getPivotIndex(arr, left, right);

            dualPivotQuickSort(arr, left, piv[0] - 1);
            dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
            dualPivotQuickSort(arr, piv[1] + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 24, 8, 42, 75, 29, 77, 38, 57 };

        dualPivotQuickSort(arr, 0, arr.length - 1);

        for (int i = 0; i <  arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}