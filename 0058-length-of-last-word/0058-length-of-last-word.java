class Solution {
    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;

        // Last ke spaces ignore karo
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int length = 0;

        // Last word count karo
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}