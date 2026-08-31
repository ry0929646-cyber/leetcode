class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {

            List<Integer> current = new ArrayList<>();

            // First and last element are always 1
            current.add(1);

            for (int col = 1; col < row; col++) {
                int value = triangle.get(row - 1).get(col - 1)
                           + triangle.get(row - 1).get(col);

                current.add(value);
            }

            // Last element
            if (row > 0) {
                current.add(1);
            }

            triangle.add(current);
        }

        return triangle;
    }
}