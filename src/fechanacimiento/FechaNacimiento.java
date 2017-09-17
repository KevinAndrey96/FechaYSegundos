/*
Una persona ha vivido una cantidad x de segundos, escriba un programa en lenguaje java que a partir de una fecha yyyymmdd y la cantidad de segundos pueda calcular la fecha de nacimiento.
 */
package fechanacimiento;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class FechaNacimiento {

    private static String Solicita(String m) {
        return JOptionPane.showInputDialog(m);
    }

    private static void Muestra(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    public static void main(String[] args) {
        Muestra("Bienvenido");
        int Fecha = 0;
        int Segundos = 0;
        int dia = 0;
        int mes = 0;
        int año = 0;

        boolean error = false;

        do {
            error = false;
            Fecha = Integer.parseInt(Solicita("Digite la fecha con la que quiere realizar el calculo en formato yyyymmdd"));
            if (Integer.toString(Fecha).length() != 8) {
                Muestra("Error. Por favor ingrese un valor valido");
            } else {
                año = Integer.parseInt(Integer.toString(Fecha).substring(0, 4));
                mes = Integer.parseInt(Integer.toString(Fecha).substring(4, 6));
                dia = Integer.parseInt(Integer.toString(Fecha).substring(6, 8));
                if (año < 0) {
                    Muestra("El año no puede ser menor a 0");
                    error = true;
                }
                if (mes < 0 || mes > 12) {
                    Muestra("El mes no puede ser menor a 0 ni mayor a 12");
                    error = true;
                }
                if (dia < 0 || dia > 31) {
                    Muestra("El dia no puede ser menor a 0 ni mayor 31");
                    error = true;
                }
            }
        } while (Integer.toString(Fecha).length() != 8 || error == true);
        Muestra("Fecha ingresada:\naño: " + año + "\nmes: " + mes + "\ndía: " + dia);
        do {
            Segundos = Integer.parseInt(Solicita("Digite la cantidad de segundos vividos por la persona"));
            if (Segundos <= 0 && Segundos > 2147483647) {
                Muestra("Error. Por favor ingrese un valor valido");
            }
        } while (Segundos <= 0 && Segundos > 2147483647);

        //Segundos en un día: 86400
        //Segundos en un mes de 28 días: 
        //segundos en un año: 31536000
        int DiasDeResta = 0;
        while (Segundos >= 86400) {
            DiasDeResta++;
            Segundos -= 86400;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(año, mes - 1, dia, 0, 0);

        calendar.add(Calendar.DAY_OF_YEAR, -DiasDeResta);

        Muestra("Fecha Nacimiento: " + calendar.getTime().toString().substring(4, 10) + " " + calendar.getTime().toString().substring(calendar.getTime().toString().length() - 4));

    }

}
