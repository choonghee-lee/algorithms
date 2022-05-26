class P11720_숫자의합
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String str = sc.next();

        int result = 0;
        char[] arr = str.toCharArray();
        for(int i = 0; i < size; i++)
        {
            result += arr[i] - '0';
        }
        System.out.print(result);
    }
}