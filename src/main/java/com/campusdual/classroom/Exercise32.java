package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercise32 {

    public static void main(String[] args) {

    }

    public static String generateStringToSave(String string) {

        //Si la linea es null, se genera la cadena de texto y se devuelve
        if (string == null) {
            return generateUserInputToSave();
        }

        return string;
    }

    private static String generateUserInputToSave() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while (!(string = Utils.string()).isEmpty()) {
            sb.append(string).append(System.lineSeparator());
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
