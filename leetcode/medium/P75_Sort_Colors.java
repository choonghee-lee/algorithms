public class P75_Sort_Colors {
    public void mergeSort(int[] A, int left, int right)
    {
        if(right - left < 1) return;

        int m = left + (right - left) / 2;

        mergeSort(A, left, m);
        mergeSort(A, m + 1, right);

        int[] tmp = new int[A.length];

        for(int i = left; i <= right; i++)
        {
            tmp[i] = A[i];
        }

        int k = left;
        int index1 = left;
        int index2 = m + 1;

        while(index1 <= m && index2 <= right)
        {
            if(tmp[index1] > tmp[index2])
            {
                A[k] = tmp[index2];
                k++;
                index2++;
            }
            else
            {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while(index1 <= m)
        {
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while(index2 <= m)
        {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }

    public void sortColors(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }
}
