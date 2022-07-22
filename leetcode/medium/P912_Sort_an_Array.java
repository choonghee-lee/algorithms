class P912_Sort_an_Array {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right)
    {
        if(right - left < 1)
            return;

        int m = left + (right-left) / 2;

        mergeSort(nums, left, m);
        mergeSort(nums, m+1, right);

        int[] tmp = new int[nums.length];
        for(int i = left; i <= right; i++)
        {
            tmp[i] = nums[i];
        }

        int k = left;
        int index1 = left;
        int index2 = m + 1;

        while(index1 <= m && index2 <= right)
        {
            if(tmp[index1] > tmp[index2])
            {
                nums[k] = tmp[index2];
                k++;
                index2++;
            }
            else
            {
                nums[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while(index1 <= m)
        {
            nums[k] = tmp[index1];
            k++;
            index1++;
        }

        while(index2 <= m)
        {
            nums[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}