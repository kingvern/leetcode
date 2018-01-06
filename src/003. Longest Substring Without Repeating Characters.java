class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int head = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) + 1 > head) {//make sure head does not travel back
                    head = map.get(c) + 1;
                }
            }
            map.put(c, i);
            String str = s.substring(head, i + 1);
            max = Math.max(max, str.length());
        }
        return max;
    }
}