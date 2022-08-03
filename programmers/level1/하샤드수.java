class 하샤드수 {
    public boolean solution(int x) {
        char[] chs = String.valueOf(x).toCharArray();

        int sum = 0;
        for(int i = 0; i < chs.length; i++)
        {
            sum += chs[i] - '0';
        }

        return x % sum == 0;
    }
}