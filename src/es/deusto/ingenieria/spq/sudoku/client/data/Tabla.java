package es.deusto.ingenieria.spq.sudoku.client.data;

/**
 * Created by Fiser on 25/2/15.
 */
public class Tabla {
    private Celda [][] tabla;
    public Tabla()
    {
        tabla = new Celda[9][9];
    }
    public Celda getCelda(int i, int j)
    {
        return tabla[i][j];
    }
    public void setCelda(Celda c, int i, int j)
    {
        tabla[i][j] = c;
    }
    public Celda[] getFila(int i)
    {
        return tabla[i];
    }
    public Celda[] getColumna(int j)
    {
        Celda[] col = new Celda[9];
        for(int i = 0; i<9; i++)
        {
            col[i] = tabla[i][j];
        }
        return col;
    }
    public Celda[] getBloque(int i, int j)
    {
        int b = 0;
        Celda[] bloque = new Celda[9];
        i = i -(i%3);
        j = j -(j%3);

        for(int n = i; n<i+3; n++)
        {
            for(int m = j; m<j+3; m++)
            {
                bloque[b] = tabla[n][m];
                b++;
            }
        }
        return bloque;
    }
    public boolean[][] comparar(Tabla tabla)
    {
        boolean [][] bool = new boolean[9][9];
        for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                if(this.tabla[i][j]==tabla.getCelda(i, j))
                    bool[i][j] = true;
                else
                    bool[i][j] = false;
            }
        }
        return bool;
    }
    public void copy (Tabla tabla) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.tabla[i][j] = tabla.getCelda(i, j);
            }
        }
    }
    public void clear () {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.tabla[i][j] = new Celda(0);
            }
        }
    }
    public void reset () {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!getCelda(i, j).isInicial()) {
                    this.tabla[i][j] = new Celda(0, false);
                }
            }
        }
    }
    public boolean contains(int i, int j, int n) {
        Celda[] columna = getColumna(j);
        Celda[] fila = getFila(i);
        Celda[] bloque = getBloque(i, j);

        if(contains(columna, n) || contains(fila, n) || contains(bloque, n)) {
            return true;
        } else {
            return false;
        }
    }
    public void printBoard () {
        System.out.println("-------------------");
        for (int i = 0; i < 9; i++) {
            System.out.print("|");
            for (int j = 0; j < 9; j++) {
                if (tabla[i][j] == null || tabla[i][j].equals(0)) {
                    System.out.print("*");
                } else {
                    System.out.print(tabla[i][j]);
                }
                if (j % 3 == 2) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            if (i % 3 == 2) {
                System.out.println("\n-------------------");
            } else {
                System.out.println();
            }
        }
    }


    private boolean contains (Celda[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(n)) {
                return true;
            }
        }
        return false;
    }



}
