package es.deusto.ingenieria.spq.sudoku.client.data.exceptions;

/**
 * Created by Fiser on 1/3/15.
 */
public class ValorErroneoException extends SudokuException {
    private int i, j, introducido, real;

    public ValorErroneoException(int i, int j, int introducido, int real) {
        super(false);
        this.i = i;
        this.j = j;
        this.introducido = introducido;
        this.real = real;
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

    public int getIntroducido(){
        return introducido;
    }
    public int getReal() {
        return real;
    }
    public void setIntroducido(int intr){
        this.introducido = intr;
    }
    public void setReal(int real)
    {
        this.real = real;
    }
}


