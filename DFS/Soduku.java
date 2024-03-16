// https://leetcode.cn/problems/sudoku-solver/description/
class Soduku {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;

        boolean[][] row = new boolean[9][9], col = new boolean[9][9], box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '1', k = (i / 3) * 3 + j / 3;
                row[i][num] = col[j][num] = box[k][num] = true;
            }
        }

        backtrack(board, 0, row, col, box);
    }

    boolean backtrack(char[][] board, int step, boolean[][] row, boolean[][] col, boolean[][] box) {
        if (step == 81)
            return true;

        int i = step / 9, j = step % 9, k = (i / 3) * 3 + j / 3;
        if (board[i][j] != '.')
            return backtrack(board, step + 1, row, col, box);

        for (int n = 0; n < 9; n++) {
            if (!row[i][n] && !col[j][n] && !box[k][n]) {
                board[i][j] = (char) (n + '1');
                row[i][n] = col[j][n] = box[k][n] = true;
                if (backtrack(board, step + 1, row, col, box))
                    return true;
                row[i][n] = col[j][n] = box[k][n] = false;
            }
        }

        board[i][j] = '.';
        return false;
    }
}