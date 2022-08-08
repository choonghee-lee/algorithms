class P12903_가운데글자가져오기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        char[] chs = s.toCharArray();
        int index = (int)(chs.length / 2);
        if(chs.length % 2 == 0)
        {
            sb.append(chs[index - 1]);
            sb.append(chs[index]);
        }
        else
        {
            sb.append(chs[index]);
        }

        return sb.toString();
    }
}