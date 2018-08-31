public class OneAway {

    public boolean isOneAway(String first, String second) {
        /**
         * There are three cases when One Away would be true
         * 1. One Replacement away -> "lake" & "bake"
         * 2. One Addition away -> "lake" & "ake"
         * 3. One Deletion away -> "lake" & "laker"
         */
        boolean isOneAway = false;
        if (first.length() == second.length())
            isOneAway = oneReplacementAway(first, second);
        else if (first.length() - second.length() == 1)
            isOneAway = oneEditInsert(second, first);
        else if (second.length() - first.length() == 1)
            isOneAway = oneEditInsert(first, second);

        return isOneAway;
    }

    private boolean oneReplacementAway(String first, String second) {
        boolean foundMismatch = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (!foundMismatch) {
                    foundMismatch = true;
                } else return false;
            }
        }

        return true;
    }

    private boolean oneEditInsert(String s1, String s2) {
        int s1Ptr = 0, s2Ptr = 0;
        while (s1Ptr < s1.length() && s2Ptr < s2.length()) {
            if (s1.charAt(s1Ptr) != s2.charAt(s2Ptr)) {
                if (s1Ptr != s2Ptr) return false;
                s2Ptr++;
            } else {
                s1Ptr++; s2Ptr++;
            }
        }
        return true;
    }

}
