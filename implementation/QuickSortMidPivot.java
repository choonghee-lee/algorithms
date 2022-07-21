public class QuickSortMidPivot {

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] A, int start, int end)
    {
        if(start >= end) return;

        int pivotIndex = partition(A, start, end);

        quickSort(A, start, pivotIndex - 1);
        quickSort(A, pivotIndex + 1, end);
    }

    // 중앙 피벗
    public static int partition(int[] A, int start, int end)
    {
        int mid = (start + end) / 2;
        swap(A, start, mid); // 중앙값을 1번째 요소로 시키기

        int pivot = A[start];
        int i = start;
        int j = end;

        while(i < j)
        {
            while(pivot < A[j]) { // 피벗보다 작은 수가 나올 때 까지 j--;
                j--;
            }

            while(i < j && pivot >= A[i]) { // 피벗보다 큰 수가 나올 때 까지 i++;
                i++;
            }

            swap(A, i, j); // 찾은 i와 j를 교환하기
        }

        // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
        A[start] = A[i];
        A[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 9, 1, 2, 5, 3, 88, 27, 48, 291, 33, 754, 19, 238, 774};
        quickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
