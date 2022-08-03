class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        int[] answer;
        if(arr.length == 0 || arr.length == 1)
        {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] < min)
                min = arr[i];
        }

        answer = new int[arr.length - 1];
        int j = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(min == arr[i])
                continue;

            answer[j] = arr[i];
            j++;
        }

        return answer;
    }
}