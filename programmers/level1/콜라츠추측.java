class 콜라츠추측 {
    public int solution(long num) {
        if (num == 1)
            return 0;

        for (int i = 0; i < 500; i++) {
            if (num == 1)
                return i;

            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
        }

        return -1;
    }
}