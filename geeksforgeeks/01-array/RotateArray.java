import java.math.BigInteger;

public class RotateArray {
  void rotateWithTempArray(int arr[], int d, int n)
  {
    // 1. Store the first d element in a temp array
    int temp[] = new int[d];
    for(int i = 0; i < d; i++) 
    {
      temp[i] = arr[i];
    }

    // 2. Shift rest of the arr[]
    for(int i = 0; i < n - d; i++)
    {
      arr[i] = arr[i+d];
    }

    // 3. Store back the d elements
    for(int i = 0; i < d; i++) 
    {
      arr[n-temp.length+i] = temp[i];
    }
  }

  void rotateOneByOne(int arr[], int d, int n)
  {
    // d times
    for(int j=0; j<d; j++) {

      // rotate one by one
      int temp = arr[0];
      for(int i=0; i< n - 1; i++) 
      {
        arr[i] = arr[i+1];
      }
      arr[n-1] = temp;
    }
  }

  void rotateJugglingAlgorithm(int arr[], int d, int n)
  { 
    BigInteger a = new BigInteger(Integer.toString(n));
    BigInteger b = new BigInteger(Integer.toString(d));
    int gcd = a.gcd(b).intValue();

    for(int i = 0; i < gcd; i++)
    {
      int temp = arr[i];
      for(int j = 0; j < n/gcd; j++)
      {
        temp = arr[n-gcd * j];
        arr[n-gcd * j] = arr[i];
      }
    }
  }

  void rorateReversalAlgorithm(int arr[], int d, int n) 
  {
    if(d == 0) return;
    d = d % n;
    reverseArray(arr, 0, d - 1);
    reverseArray(arr, d, n - 1);
    reverseArray(arr, 0, n - 1);
  }

  void reverseArray(int arr[], int start, int end)
  {
    int temp;
    while(start < end)
    {
      temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  void printArray(int arr[], int size)
  {
    for(int i = 0; i < size; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args)
  {
    RotateArray ra = new RotateArray();
    int arr[] = {1, 2, 3, 4, 5, 6, 7};

    ra.rotateWithTempArray(arr, 2, 7); 
    ra.printArray(arr, 7); // 3 4 5 6 7 1 2 

    ra.rotateOneByOne(arr, 3, 7);
    ra.printArray(arr, 7); // 6 7 1 2 3 4 5

    ra.rotateOneByOne(arr,3, 7);
    ra.printArray(arr, 7); // 2 3 4 5 6 7 1

    ra.rotateOneByOne(arr, 2, 7);
    ra.printArray(arr, 7); // 4 5 6 7 1 2 3
  }
}