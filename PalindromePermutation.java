import java.util.HashMap;

public class PalindromePermutation {

    private int[] charTable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

    public boolean isPalindromePerm(String str) {
        /**
         * A palindrome must have at-most only one odd numbered Char
         * We can create a Hash Map to keep count of all chars in the string
         * Return false if there are more than one odd numbered chars
         */
        mapChars(str);
        boolean foundOdd = false;
        for (int val: charTable) {
            if (val % 2 != 0) {
                if (!foundOdd) {
                    foundOdd = true;
                } else
                    return false;
            }
        }

        return true;
    }

    public void mapChars(String str) {

        for (Character strChar: str.toCharArray()) {
            if (strChar >= 'a' && strChar <= 'z') {
                int charNumVal = Character.getNumericValue(strChar) - Character.getNumericValue('a');
                charTable[charNumVal]++;
            }
        }
    }

}
