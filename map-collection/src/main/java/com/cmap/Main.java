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
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        long inicio = System.nanoTime();
        // Dependiendo de la opción elegida, inicializa el tipo de mapa correspondiente
        switch (opcion) {
            case 1:
                System.out.println("HasMap");
                IMap<String, String> cHashMap = new cHashMap<>();
                inicializarMapa(cHashMap, datos);
                break;
            case 2:
                System.out.println("TreeMap");
                IMap<String, String> cTreeMap = new cTreeMap<>();
                inicializarMapa(cTreeMap, datos);
                break;
            case 3:
                System.out.println("LinkedHashMap");
                IMap<String, String> linkedHM = new LinkedHM<>();
                inicializarMapa(linkedHM, datos);
                break;
            default:
                System.out.println("Opción no válida");
        }
        long fin = System.nanoTime();
        long tiempoTranscurrido = fin - inicio;
        System.out.println("Tiempo transcurrido: " + tiempoTranscurrido + " nanosegundos");
    }

    public static void inicializarMapa(IMap<String, String> mapa, List<String[]> datos) {
        for (String[] dato : datos) {
            mapa.put(dato[0], dato[1]);
        }
    }
}
