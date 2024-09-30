package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise32 {

    public static void main(String[] args) {
        System.out.println("Ejercicio 32 - Escritura de ficheros");
        printToFile(generateStringToSave(null));
    }

    public static String generateStringToSave(String string) {

        //Si la linea es null, se genera la cadena de texto y se devuelve
        if (string == null) {
            return generateUserInputToSave();
        }

        return string;
    }

    //Se genera la cadena de texto y se devuelve
    private static String generateUserInputToSave() {

        //Contador para tener en cuenta el numero de Enters introducidos
        int cont = 0;
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;


        //Se comprueba que no se pulse enter 2 veces seguidas, y se va añadiendo en un Stringbuilder el texto a escribir
        while (cont < 2) {
            string = new Scanner(System.in).nextLine();

            //En caso de que se pulse enter el contador aumenta
            if (string.isEmpty()) {
                cont++;

            }
            //En caso contrario el contador se resetea a 0 y se añade la linea de texto al String
            else {
                cont = 0;
                sb.append(string).append(System.lineSeparator());

            }

        }
        return sb.toString();
    }

    public static void printToFile(String string) {

        //Se genera el bufferedWriter y se escribe en el fichero
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/data.txt"))) {

            bw.write(string);
            System.out.println("Se ha escrito en el fichero correctamente");

        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero");
        }
    }


}
