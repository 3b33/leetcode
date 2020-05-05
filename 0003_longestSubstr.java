class Solution {
    boolean debug = false;
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if (s.length() > 0) {
            maxLen = 1;
            mainfor: for (int a = 0; a < s.length(); a++) {
                if (s.length() - a + 1 <= maxLen) { continue; }
                String checked = "";
                for (int b = a + 1; b < s.length(); b++) {
                    String split = s.substring(a,b);
                    if (debug) { System.out.println("Finding "+s.charAt(b)+" from "+split); }
                    if (split.indexOf(s.charAt(b)) != -1) {
                        if (debug) { System.out.println("Found"); }
                        maxLen = split.length() > maxLen ? split.length() : maxLen;
                        if (debug) { System.out.println("maxLen = " + maxLen); }
                        continue mainfor;
                    }
                    else {
                        maxLen = split.length() + 1 > maxLen ? split.length() + 1 : maxLen;
                        if (debug) { System.out.println("maxLen = " + maxLen); }
                    }
                }
            }
        }
        return maxLen;
    }
}