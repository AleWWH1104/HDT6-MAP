package com.cmap;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Lee los datos del archivo
        List<String[]> datos = lector.leerArchivo("C:\\Users\\domin\\OneDrive\\Escritorio\\DHT6\\HDT6-MAP\\map-collection\\src\\main\\java\\com\\cmap\\cards_desc.txt");

        // Crea el scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Muestra el menú
        System.out.println("Seleccione el tipo de mapa:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        // Lee la opción del usuario
        String opcionMap = scanner.nextLine();
        


        // Utiliza el FactoryMap para crear el tipo de mapa correspondiente
        FactoryMap factoryMap = new FactoryMap();
        IMap mapa = factoryMap.createMap(opcionMap);
        

        if (mapa == null) {
            System.out.println("Opción no válida");
            return;
        } else {
            inicializarMapa(mapa, datos);
        }

        // Menú de operaciones para el usuario
        boolean salir = false;

        long tInicio;
        long tFin;
        while (!salir) {
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
                    System.out.println("Ingrese el nombre de la carta:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el tipo de la carta:");
                    String tipo = scanner.nextLine();
                    tInicio = System.nanoTime();
                    mapa.addCard(nombre, tipo);
                    tFin = System.nanoTime();
                    System.out.println("Con: " + mapa.toString() + " T inicio: " + tInicio + " T fin: " + tFin + " Total: " + (tFin-tInicio));
                    break;
                case "2":
                    System.out.println("Ingrese el nombre de la carta:");
                    String carta = scanner.nextLine();
                    tInicio = System.nanoTime();
                    String tipoCarta = mapa.getCardType(carta);
                    if (tipoCarta != null) {
                        System.out.println("El tipo de la carta " + carta + " es " + tipoCarta);
                    } else {
                        System.out.println("La carta " + carta + " no existe en la colección.");
                    }
                    tFin = System.nanoTime();
                    System.out.println("Con: " + mapa.toString() + " T inicio: " + tInicio + " T fin: " + tFin + " Total: " + (tFin-tInicio));
                    break;
                case "3":
                    tInicio = System.nanoTime();
                    Map<String, Integer> coleccionUsuario = mapa.getUserCollection();
                    for (Map.Entry<String, Integer> entry : coleccionUsuario.entrySet()) {
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + mapa.getCardType(entry.getKey()) + ", Cantidad: " + entry.getValue());
                    }
                    tFin = System.nanoTime();
                    System.out.println("Con: " + mapa.toString() + " T inicio: " + tInicio + " T fin: " + tFin + " Total: " + (tFin-tInicio));
                    break;
                case "4":
                    tInicio = System.nanoTime();
                    mostrarColeccionOrdenadaPorTipo(mapa);
                    tFin = System.nanoTime();
                    System.out.println("Con: " + mapa.toString() + " T inicio: " + tInicio + " T fin: " + tFin + " Total: " + (tFin-tInicio));
                    break;
                case "5":
                    tInicio = System.nanoTime();
                    List<String> todasLasCartas = mapa.getAllCards();
                    for (String cartaNombre : todasLasCartas) {
                        System.out.println("Nombre: " + cartaNombre + ", Tipo: " + mapa.getCardType(cartaNombre));
                    }
                    tFin = System.nanoTime();
                    System.out.println("Con: " + mapa.toString() + " T inicio: " + tInicio + " T fin: " + tFin + " Total: " + (tFin-tInicio));
                    break;
                case "6":
                    tInicio = System.nanoTime();
                    mostrarTodasLasCartasOrdenadasPorTipo(mapa);
                    tFin = System.nanoTime();
                    System.out.println("Con: " + mapa.toString() + " T inicio: " + tInicio + " T fin: " + tFin + " Total: " + (tFin-tInicio));
                    break;
                case "7":
                    salir = true;
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

    public static void mostrarColeccionOrdenadaPorTipo(IMap mapa) {
        Map<String, Integer> coleccionUsuario = mapa.getUserCollection();
        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(coleccionUsuario.entrySet());

        // Definir comparador para ordenar por tipo de carta
        Collections.sort(listaOrdenada, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                String tipo1 = mapa.getCardType(entry1.getKey());
                String tipo2 = mapa.getCardType(entry2.getKey());
                return tipo1.compareTo(tipo2);
            }
        });

        // Imprimir la colección ordenada por tipo
        for (Map.Entry<String, Integer> entry : listaOrdenada) {
            String nombreCarta = entry.getKey();
            String tipoCarta = mapa.getCardType(nombreCarta);
            int cantidad = entry.getValue();
            System.out.println("Nombre: " + nombreCarta + ", Tipo: " + tipoCarta + ", Cantidad: " + cantidad);
        }
    }

    public static void mostrarTodasLasCartasOrdenadasPorTipo(IMap mapa) {
        List<String> todasLasCartas = mapa.getAllCards();

        // Ordenar todas las cartas por tipo
        Collections.sort(todasLasCartas, new Comparator<String>() {
            @Override
            public int compare(String carta1, String carta2) {
                String tipo1 = mapa.getCardType(carta1);
                String tipo2 = mapa.getCardType(carta2);
                return tipo1.compareTo(tipo2);
            }
        });

        // Imprimir todas las cartas ordenadas por tipo
        for (String carta : todasLasCartas) {
            String tipoCarta = mapa.getCardType(carta);
            System.out.println("Nombre: " + carta + ", Tipo: " + tipoCarta);
        }
    }
}
