package es.deusto.ingenieria.spq.sudoku.client.data;
/***********************************************
 * Project: 			Sudoku
 ************************************************
 *
 * @author 	Claire Giry           <br>
 *			Hans-Peter Hoellwirth <br>
 *			Scott Cantisani       <br>
 *			Simranbir Singh       <br>
 *			Oana Radu             <br>
 *
 * @since
 * Creation date:	28.02.2013 <br>
 * Last updated:		14.03.2013 <br>
 ***********************************************/

import java.util.Random;

public class Generator {

    private Tabla board = new Tabla();
    private Tabla srcBoard = new Tabla(); //srcBoard is a board to backtrack to if something goes wrong

    /**
     * Create new generator object. <p>
     *
     * @author
     * Created by: Hans-Peter Hoellwirth <br>
     * Edited by:  -
     */
    public Generator () {
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
    public Tabla getTabla () {
        return this.board;
    }

    /**
     * Generate a new solvable board. <p>
     *
     * @author
     * Created by: Scott Cantisani  <br>
     * Edited by:  -
     *
     * @param diff difficulty level (1-3)
     */
    public void generateBoard (int diff) {
        initBoard();
        Random random = new Random();
        if (diff == 1) {
            dig(20 + random.nextInt(5));
        } else if (diff == 2) {
            dig(30 + random.nextInt(5));
        } else if (diff == 3) {
            dig(40 + random.nextInt(5));
        } else {
            dig(50+ random.nextInt(5));
        }
    }

    /**
     * Initialize board. <p>
     * Fills the board up randomly with numbers, then attempts to solve it to create a finished puzzle.
     *
     * @author
     * Created by: Scott Cantisani  <br>
     * Edited by:  -
     */
    private void initBoard () {
        int i, j, n;

        do {
            board.clear();
            for (int k = 0; k < 80; k++) {
                i = random();
                j = random();
                n = random() + 1;

                if (!board.contains(i, j, n)) {
                    board.setCelda(new Celda(n, true), i, j);
                }
            }
        } while (!solvable());

        srcBoard.copy(board);
    }

    /**
     * Get random number. <p>
     *
     * @author
     * Created by: Scott Cantisani  <br>
     * Edited by:  -
     *
     * @return random number (0-8)
     */
    private int random () {
        Random rand = new Random();
        return rand.nextInt(9);
    }

    /**
     * Check if board is solvable. <p>
     *
     * @author
     * Created by: Hans-Peter Hoellwirth  <br>
     * Edited by:  -
     *
     * @return true if solvable, otherwise false
     */
    private boolean solvable () {
        Solver solver = new Solver(board, true);
        return solver.solveBoard();
    }

    /**
     * Check for multiple solutions by brute force. <p>
     *
     * NOTE: Definitely not the best way to do this but using it for now to test the generator <p>
     *
     * @author
     * Created by: Scott Cantisani  <br>
     * Edited by:  -
     *
     * @return true if solvable, otherwise false
     */
    private boolean multSol () {
        int n = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (srcBoard.getCelda(i,j) != null && srcBoard.getCelda(i,j).equals(0)) {
                    //if a cell in the original puzzle is empty
                    for (int k = 1; k < 10; k++) {
                        //loop through all possible numbers for this cell
                        board.copy(srcBoard);
                        board.setCelda(new Celda(k, true), i, j);
                        if (!board.contains(i, j, k) && solvable()) {
                            //count all possible solutions for numbers in this cell
                            n++;
                        }
                    }

                    if (n > 1) {
                        //if there is more than one possible solution, return true
                        return true;
                    }
                    board.setCelda(new Celda(0, false), i, j);
                }
            }
        }
        //if after testing all possible numbers for all empty cells there is not more than one solution, return false
        return false;
    }

    /**
     * Clear n randomly placed cells. <p>
     *
     * @author
     * Created by: Scott Cantisani  <br>
     * Edited by:  -
     *
     * @param n number of cells to clear
     */
    private void dig (int n) {
        int i, j, k, dug = 0;
        while (dug < n) {
            i = random();
            j = random();
            if (board.getCelda(i, j) == null || !board.getCelda(i, j).equals(0)) {
                if (board.getCelda(i, j) == null) {
                    k = 0;
                } else {
                    k = board.getCelda(i, j).getNumero();
                }
                board.setCelda(new Celda(0, false), i, j);
                if (!multSol()) {
                    dug++;
                } else {
                    board.setCelda(new Celda(k, true), i, j);
                }
            }
        }
    }
}
