class 시저암호 {

    public String solution(String s, int n) {
        final int bound = 26 - n;
        final char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0x20)
                arr[i] += (arr[i] & 0x1F) <= bound? n : -bound;
        }

        return new String(arr);
    }
}