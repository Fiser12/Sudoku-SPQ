package controller.Exceptions;

/**
 * Created by Fiser on 1/3/15.
 */
public class SudokuException extends Exception {
    private boolean correcto;

    public SudokuException(boolean correcto) {
        super();
        this.correcto = correcto;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }
}
