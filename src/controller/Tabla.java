package controller;

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
    public Celda[] getCelda(int i)
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
    public Celda[] getBloqueo(int i, int j)
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
}
