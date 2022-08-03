class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        char[] k = Long.valueOf(n).toString().toCharArray();
        int[] answer = new int[k.length];
        int j = 0;
        for(int i = k.length - 1; i > -1; i--)
        {
            answer[j] = k[i] - '0';
            j++;
        }

        return answer;
    }
}