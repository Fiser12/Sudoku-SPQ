import controller.Exceptions.CeldaInicialException;
import controller.Exceptions.SudokuException;
import controller.Sudoku;

public class Main
{

    public static void main(String[] args) {
        Sudoku prueba = new Sudoku(3);
        prueba.showEjercicio();
        prueba.showSolucion();

        try {
            prueba.setValor(0, 0, 4);
            prueba.showEjercicio();
            prueba.showSolucion();
        } catch (SudokuException e) {
            if(e instanceof CeldaInicialException) {
                System.out.println("Error, celda incial");
            }
            else
            {
                System.out.println("Error valor erroneo");
            }
        }
    }
}
