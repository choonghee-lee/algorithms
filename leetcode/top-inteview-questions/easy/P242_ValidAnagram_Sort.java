public class P242_ValidAnagram {
    static void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] getPivotIndex(char[] arr, int start, int end)
    {
        if(arr[start] > arr[end])
            swap(arr, start, end);

        int swapIdxStart = start + 1;
        int swapIdxEnd = end - 1;
        int i = start + 1;
        char pivotStart = arr[start];
        char pivotEnd = arr[end];

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

    static void dualPivotQuickSort(char[] arr, int left, int right)
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

    static boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        dualPivotQuickSort(ch1, 0, ch1.length - 1);
        dualPivotQuickSort(ch2, 0, ch2.length - 1);

        return Objects.equals(new String(ch1), new String(ch2));
    }
}