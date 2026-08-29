class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> basket = new HashMap<>();

        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Current fruit ko basket mein add karo
            basket.put(fruits[right],
                    basket.getOrDefault(fruits[right], 0) + 1);

            // Sirf 2 types of fruits allowed
            while (basket.size() > 2) {

                int fruit = fruits[left];

                basket.put(fruit, basket.get(fruit) - 1);

                if (basket.get(fruit) == 0) {
                    basket.remove(fruit);
                }

                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}