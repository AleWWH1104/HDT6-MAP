package com.cmap;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

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

        // Utiliza el FactoryMap para crear el tipo de mapa correspondiente
        FactoryMap factoryMap = new FactoryMap();
        IMap mapa = factoryMap.createMap(opcion);

        if (mapa == null) {
            System.out.println("Opción no válida");
            return;
        } else {
            inicializarMapa(mapa, datos);
        }

        // Menú de operaciones para el usuario
        boolean salir = false;
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
                    mapa.addCard(nombre, tipo);
                    break;
                case "2":
                    System.out.println("Ingrese el nombre de la carta:");
                    String carta = scanner.nextLine();
                    String tipoCarta = mapa.getCardType(carta);
                    if (tipoCarta != null) {
                        System.out.println("El tipo de la carta " + carta + " es " + tipoCarta);
                    } else {
                        System.out.println("La carta " + carta + " no existe en la colección.");
                    }
                    break;
                case "3":
                    Map<String, Integer> coleccionUsuario = mapa.getUserCollection();
                    for (Map.Entry<String, Integer> entry : coleccionUsuario.entrySet()) {
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + mapa.getCardType(entry.getKey()) + ", Cantidad: " + entry.getValue());
                    }
                    break;
                case "4":
                    break;
                case "5":
                    List<String> todasLasCartas = mapa.getAllCards();
                    for (String cartaNombre : todasLasCartas) {
                        System.out.println("Nombre: " + cartaNombre + ", Tipo: " + mapa.getCardType(cartaNombre));
                    }
                    break;
                case "6":
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
}
