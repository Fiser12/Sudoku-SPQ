package controller.Exceptions;

/**
 * Created by Fiser on 1/3/15.
 */
public class CeldaInicialException extends SudokuException{
    private int i, j;

    public CeldaInicialException(int i, int j) {
        super(false);
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
