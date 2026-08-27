class Solution {

    public boolean exist(char[][] board, String word) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                if (board[row][col] == word.charAt(0)) {
                    if (search(board, word, row, col, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word,
                           int row, int col, int index) {

        // Word complete
        if (index == word.length()) {
            return true;
        }

        // Out of bounds or character doesn't match
        if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

    
        char temp = board[row][col];
        board[row][col] = '#';

        // Check all 4 directions
        boolean found =
                search(board, word, row + 1, col, index + 1) ||
                search(board, word, row - 1, col, index + 1) ||
                search(board, word, row, col + 1, index + 1) ||
                search(board, word, row, col - 1, index + 1);

    
        board[row][col] = temp;

        return found;
    }
}