class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        // Total sum of all cards
        int total = 0;
        for (int card : cardPoints) {
            total += card;
        }

        // Cards we DON'T take
        int windowSize = n - k;

        // If we take all cards
        if (windowSize == 0) {
            return total;
        }

        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minWindow = windowSum;

        // Find minimum sum window
        for (int right = windowSize; right < n; right++) {
            windowSum += cardPoints[right];
            windowSum -= cardPoints[right - windowSize];

            minWindow = Math.min(minWindow, windowSum);
        }

        return total - minWindow;
    }
}