class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;

        if(s.length() != 4 && s.length() != 6)
            return false;

        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++)
        {
            if(chs[i]  < 48 || chs[i] > 57)
            {
                answer = false;
                break;
            }

        }

        return answer;
    }
}