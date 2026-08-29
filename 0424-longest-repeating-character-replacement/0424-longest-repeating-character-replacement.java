class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // Window mein sabse frequent character
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // Characters that need replacement
            int replacements = (right - left + 1) - maxFreq;

            while (replacements > k) {
                freq[s.charAt(left) - 'A']--;
                left++;

                replacements = (right - left + 1) - maxFreq;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}