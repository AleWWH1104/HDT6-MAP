package com.cmap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Lee los datos del archivo
        List<String[]> datos = lector.leerArchivo("/Users/alejandraayala/Desktop/EstructuraDatos/HDT6-MAP/map-collection/src/main/java/com/cmap/cards_desc.txt");

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
        FactoryMap factoryMap = new FactoryMap();
        IMap mapa = factoryMap.createMap(opcion);

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

        // Menú de operaciones para el usuario
        boolean salir = true;
        while (salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar una carta a la colección del usuario");
            System.out.println("2. Mostrar el tipo de una carta específica");
            System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección");
            System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo");
            System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes");
            System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo");
            System.out.println("7. Salir");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                    salir = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    scanner.close();
    }

    public static void inicializarMapa(IMap mapa, List<String[]> datos) {
        for (String[] dato : datos) {
            mapa.addCard(dato[0], dato[1]);
        }
    }
}
