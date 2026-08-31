class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0;
        int oddCount = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {

            // Odd number mila
            if (nums[right] % 2 != 0) {
                oddCount++;
            }

            // K se zyada odd ho gaye
            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            // Current right ke saath saare valid subarrays
            answer += right - left + 1;
        }

        return answer;
    }
}