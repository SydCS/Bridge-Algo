import java.util.*;

class Solution {
    static int N;
    static int[] queens;

    public List<List<String>> solveNQueens(int n) {
        N = n;
        queens = new int[N];
        Arrays.fill(queens, -1);

        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        List<List<String>> solutions = new ArrayList<List<String>>();
        backtrack(solutions, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int row, Set<Integer> columns,
            Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == N) {
            List<String> board = generateBoard(queens, N);
            solutions.add(board);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (columns.contains(i)) {
                continue;
            }
            int diagonal1 = row - i;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }

            queens[row] = i;
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);

            backtrack(solutions, row + 1, columns, diagonals1, diagonals2);

            queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}