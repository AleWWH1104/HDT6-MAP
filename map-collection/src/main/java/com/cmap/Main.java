package com.cmap;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Lee los datos del archivo
        List<String[]> datos = lector.leerArchivo("map-collection\\src\\main\\java\\com\\cmap\\cards_desc.txt");

        // Crea el scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Muestra el menú
        System.out.println("Seleccione el tipo de mapa:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        // Lee la opción del usuario
        String opcion = scanner.nextLine();

        long inicio = System.nanoTime();

        // Utiliza el FactoryMap para crear el tipo de mapa correspondiente
        FactoryMap<String, String> factoryMap = new FactoryMap<>();
        IMap<String, String> mapa = factoryMap.createMap(opcion);

        
        if (mapa == null) {
            System.out.println("Opción no válida");
        } else {
            inicializarMapa(mapa, datos);
        }

        long fin = System.nanoTime();
        long tiempoTranscurrido = fin - inicio;
        System.out.println("Tiempo Inicio: " + inicio);
        System.out.println("Tiempo Fin: " + fin);
        System.out.println("Tiempo transcurrido: " + tiempoTranscurrido + " nanosegundos");
    }

    public static void inicializarMapa(IMap<String, String> mapa, List<String[]> datos) {
        for (String[] dato : datos) {
            mapa.put(dato[0], dato[1]);
        }
    }
}
