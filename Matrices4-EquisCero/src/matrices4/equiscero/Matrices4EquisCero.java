package matrices4.equiscero;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
  @author Gali :B

    Elaborar una aplicacion de Java with Ant, el cual realice el juego de 
    "equis - cero" usando matrices, debe considerar lo siguiente:

      * Se jugará un usuario a la vez.
      * Se mostrará el tablón despues de cada jugada (usando JTextArea).
      * No puede sobreescribir jugada de ningun jugador 
        (La casilla que esté ocupada ya no se puede modificar).
      * Hacer validaciones estrictas para cada movimiento.
      * Cuando un jugador de los dos gane, terminará el juego.

 */
public class Matrices4EquisCero {

    public static void main(String[] args) {
        String matriz[][] = new String[3][3], salida = "";
        int fila, columna, jugador = 1, cualFila, cualColumna;
        boolean ganador = false;
        JTextArea hoja = new JTextArea();

        for (fila = 0; fila < 3; fila++) {
            for (columna = 0; columna < 3; columna++) {
                matriz[fila][columna] = "";
            }
        }

        while (!ganador) {

            do {
                cualFila = Integer.parseInt(JOptionPane.showInputDialog("Jugador #" + jugador + " Ingrese la fila que desea"));
                cualColumna = Integer.parseInt(JOptionPane.showInputDialog("Jugador #" + jugador + "Ingrese la columna que desea"));

                if ((cualFila < 0 || cualFila > 3) || (cualColumna < 0 || cualColumna > 3)) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor en el rango");
                } else if (matriz[cualFila][cualColumna].equals("X") || matriz[cualFila][cualColumna].equals("O")) {
                    JOptionPane.showMessageDialog(null, "Jugador #" + jugador + " Ingrese una jugada valida");
                }
            } while ((cualFila < 0 || cualFila > 3)
                    || (cualColumna < 0 || cualColumna > 3)
                    || (matriz[cualFila][cualColumna].equals("X") || matriz[cualFila][cualColumna].equals("O")));

            if (jugador == 1) {
                matriz[cualFila][cualColumna] = "X";
                jugador = 2;
            } else if (jugador == 2) {
                matriz[cualFila][cualColumna] = "O";
                jugador = 1;
            }

            for (fila = 0; fila < 3; fila++) {
                for (columna = 0; columna < 3; columna++) {
                    if (columna == 2) {
                        salida += matriz[fila][columna] + "\n";
                    } else {
                        salida += matriz[fila][columna] + "\t";
                    }
                }
            }
            hoja.setText(salida);
            JOptionPane.showMessageDialog(null, hoja);
            salida = "";

            if ((matriz[0][0].equals("X") && matriz[0][1].equals("X") && matriz[0][2].equals("X"))
                    || (matriz[1][0].equals("X") && matriz[1][1].equals("X") && matriz[1][2].equals("X"))
                    || (matriz[2][0].equals("X") && matriz[2][1].equals("X") && matriz[2][2].equals("X"))
                    || (matriz[0][0].equals("X") && matriz[1][0].equals("X") && matriz[2][0].equals("X"))
                    || (matriz[0][1].equals("X") && matriz[1][1].equals("X") && matriz[2][1].equals("X"))
                    || (matriz[0][2].equals("X") && matriz[1][2].equals("X") && matriz[2][2].equals("X"))
                    || (matriz[0][0].equals("X") && matriz[1][1].equals("X") && matriz[2][2].equals("X"))
                    || (matriz[0][2].equals("X") && matriz[1][1].equals("X") && matriz[2][0].equals("X"))) {
                JOptionPane.showMessageDialog(null, "Felicidades Jugador #1 Ha ganado!");
                ganador = true;

            } else if ((matriz[0][0].equals("O") && matriz[0][1].equals("O") && matriz[0][2].equals("O"))
                    || (matriz[1][0].equals("O") && matriz[1][1].equals("O") && matriz[1][2].equals("O"))
                    || (matriz[2][0].equals("O") && matriz[2][1].equals("O") && matriz[2][2].equals("O"))
                    || (matriz[0][0].equals("O") && matriz[1][0].equals("O") && matriz[2][0].equals("O"))
                    || (matriz[0][1].equals("O") && matriz[1][1].equals("O") && matriz[2][1].equals("O"))
                    || (matriz[0][2].equals("O") && matriz[1][2].equals("O") && matriz[2][2].equals("O"))
                    || (matriz[0][0].equals("O") && matriz[1][1].equals("O") && matriz[2][2].equals("O"))
                    || (matriz[0][2].equals("O") && matriz[1][1].equals("O") && matriz[2][0].equals("O"))) {
                JOptionPane.showMessageDialog(null, "Felicidades Jugador #2 Ha ganado!");
                ganador = true;

            }

        }

    }

}
