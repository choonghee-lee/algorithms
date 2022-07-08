class P28_Implement_StrStr {
    public int strStr(String haystack, String needle) {
        byte[] s1 = haystack.getBytes();
        byte[] s2 = needle.getBytes();

        if(s2.length == 0) return 0;
        if(s1.length == 0) return -1;

        byte first = s2[0];
        int max = (s1.length - s2.length);

        for(int i = 0; i <= max; i++) {

            if(s1[i] != first) {
                while(++i <= max && s1[i] != first);
            }

            if(i <= max) {
                int j = i + 1;
                int end = j + s2.length - 1;
                for(int k = 1; j < end && s1[j] == s2[k]; j++, k++);
                if(j == end) {
                    return i;
                }
            }
        }

        return -1;
    }
}