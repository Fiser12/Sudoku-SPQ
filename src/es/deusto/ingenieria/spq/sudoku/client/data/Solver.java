package es.deusto.ingenieria.spq.sudoku.client.data;
public class Solver {

    private Tabla board;
    private boolean generated;

    /**
     * Create new solver object. <p>
     *
     * @author
     * Created by: Hans-Peter Hoellwirth <br>
     * Edited by:  -
     *
     * @param board board to solve
     */
    public Solver (Tabla board) {
        this.board = board;
        this.generated = false;
    }

    /**
     * Create new solver object. <p>
     *
     * @author
     * Created by: Hans-Peter Hoellwirth <br>
     * Edited by:  -
     *
     * @param board board to solve
     * @param generated is solver used for generator
     */
    public Solver (Tabla board, boolean generated) {
        this.board = board;
        this.generated = generated;
    }

    /**
     * Get the board. <p>
     *
     * @author
     * Created by: Hans-Peter Hoellwirth <br>
     * Edited by:  -
     *
     * @return board
     */
    public Tabla getBoard () {
        return this.board;
    }

    /**
     * Solve board. <p>
     *
     * @author
     * Created by: Scott Cantisani <br>
     * Edited by:  -
     */
    public boolean solveBoard () {
        return solveBoard(0, 0, 1);
    }

    /**
     * Solve board. <p>
     *
     * @author
     * Created by: Scott Cantisani <br>
     * Edited by:  -
     */
    private boolean solveBoard (int i, int j, int n) {
        if (i == 9 && j == 0) {
            //if at end of board, puzzle solved
            return true;
        } else {
            if (board.getCelda(i, j) != null && board.getCelda(i, j).equals(0)) {
                //if the cell is empty
                while (n <= 9) {
                    if (board.contains(i, j, n)) {
                        //find the first possible number for the cell
                        n++;
                    } else {
                        //set the cell to this number
                        board.setCelda(new Celda(n, generated), i, j);
                        if (solveBoard(next(i, j)[0], next(i, j)[1], 1)) {
                            //if the board is solvable with this number, return true
                            board.setCelda(new Celda(n, generated), i, j);
                            return true;
                        } else {
                            //if not, try the next possible number for the cell
                            board.setCelda(new Celda(0, generated), i, j);
                            return solveBoard(i, j, n+1);
                        }
                    }
                }
                //if no possible numbers lead to a solution, return false
                return false;
            } else {
                //if not, go to the next cell
                return solveBoard(next(i, j)[0], next(i, j)[1], 1);
            }
        }
    }

    /**
     * Get next cell, reading left to right and top to bottom. <p>
     *
     * @author
     * Created by: Scott Cantisani <br>
     * Edited by:  -
     */
    private int[] next (int i, int j) {
        int[] next = new int[2];

        j += 1;
        if (j > 8) {
            i += 1;
            j = 0;
        }

        next[0] = i;
        next[1] = j;
        return next;
    }
}
