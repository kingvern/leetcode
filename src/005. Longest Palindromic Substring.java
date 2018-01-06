class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        int l = s.length();
        int startIndex = 0;
        int maxLen = 1;
        boolean[][] A = new boolean[l][l];
        for (int i = 0, j = 0; i < l; i++, j++)
            A[i][j] = true;

        for (int i = 0, j = i + 1; j < l; i++, j++) {
            if (s.charAt(i) == s.charAt(j)) {
                A[i][j] = true;
                startIndex = i;
                maxLen = 2;
            }
        }

        for (int k = 3; k <= l; k++) {
            for (int i = 0, j = k - 1; j < l; i++, j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    A[i][j] = A[i + 1][j - 1];
                    if (A[i][j]) {
                        if (k > maxLen) {
                            startIndex = i;
                            maxLen = k;
                        }
                    }
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }
}