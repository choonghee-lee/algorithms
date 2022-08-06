class 문자열을정수로바꾸기 {

    public int solution(String s) {
        boolean isNegative = false;
        int temp = 0;

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '-')
            {
                isNegative = true;
            }
            else if(ch != '+')
            {
                temp = temp * 10 + (ch - '0');
            }
        }

        return isNegative ? temp * -1 : temp;
    }
}