package com.cmap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class lector {
    
    public static List<String[]> leerArchivo(String nombreArchivo) {
        List<String[]> datos = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] partes = line.split("\\|");
                if (partes.length == 2) {
                    datos.add(new String[]{partes[0].trim(), partes[1].trim()});
                } else {
                    System.out.println("Error en el formato de línea: " + line);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace(); //imprime el error
        }
        return datos;
    }
}
