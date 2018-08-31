
public class uniqueChars {
    public static void main(String[] args) {
        System.out.println(isUnique("asymptote"));
    }

    private static boolean isUnique(String str) {
        // If String's length is greater than 128 it can't have all unique chars
        if (str.length() > 128)
            return false;
        // Create a bool array of size of total ascii chars
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            // Map the int representation of char to the bool array
            int val = str.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }

        return true;
    }

}
