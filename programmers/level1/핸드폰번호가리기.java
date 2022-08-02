class 핸드폰번호가리기 {
    public String solution(String phoneNumber) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < phoneNumber.length() - 4; i++)
        {
            sb.append('*');
        }

        sb.append(phoneNumber.substring(sb.length()));

        return sb.toString();
    }
}