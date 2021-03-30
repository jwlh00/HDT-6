/*
Andrea Lam, 20102
Jun Woo Lee, 20358
Main
Fecha de creación: 19/03/21
Modificación 1: 23/03/21
Referencias: https://stackoverflow.com/questions/29061782/java-read-txt-file-to-hashmap-split-by/29062134
 */



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    public static void main(String args[]){
        Instance factory = new Instance();
        Scanner scan = new Scanner(System.in);

        HashMap<String, String> cartas = new HashMap<String, String>();
        Map<String, String> coleccionUsuario ;
        boolean menuPrincipal = true;
        boolean menuSecundario2;

        int contadorMonstruo = 0;
        int contadorHechizo = 0;
        int contadorTrampa = 0;

        //Leer el archivo
        try{
            String file = "cards_desc.txt"; //busca el archivo llamado datos
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split("\\|", 2);
                if (parts.length >= 2)
                {
                    String key = parts[0];
                    String value = parts[1];
                    cartas.put(key, value);
                } else {
                    System.out.println("ignoring line: " + line);
                }
            }


            reader.close();


        }
        catch (Exception e){
            System.out.println("No se encontro el archivo");
        }


        while(menuPrincipal){
            boolean menuSecundario = true;
            try{
                System.out.println("\nMenu Principal");
                System.out.println("1. HashMap");
                System.out.println("2. LinkedHashMap");
                System.out.println("3. TreeMap");
                System.out.println("4. Salir\n");

                int opcion = scan.nextInt();
                scan.nextLine();

                if(opcion >= 1 && opcion <= 3){
                    //Crea el Mapa de la opcion elegida
                    coleccionUsuario = factory.getInstance(opcion);

                    while(menuSecundario){
                        try{
                            System.out.println("\nMenu Secundario");
                            System.out.println("1. Agregar una carta a la collecion del usuario.");
                            System.out.println("2. Mostrar el tipon de una carta especificada.");
                            System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección.");
                            System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo.");
                            System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes.");
                            System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.");
                            System.out.println("7. Regresar al Mennu Principal\n");
                            int eleccion = scan.nextInt();
                            scan.nextLine();

                            switch(eleccion){
                                case 1:{
                                    //Agregar una carta a la collecion del usuario.
                                    try{

                                        System.out.println("Ingrese el nombre de la carta que desea agregar");
                                        String cartaElejida = scan.nextLine();
                                        String tempValue = cartas.get(cartaElejida);
                                        coleccionUsuario.put(cartaElejida, tempValue);


                                        if(cartas.get(cartaElejida) == null){
                                            System.out.println("Esa carta no existe");
                                        }
                                        cartas.remove(cartaElejida);


                                    }catch(InputMismatchException e){
                                        scan.nextLine();
                                        System.err.println("Se ingreso una opcion invalida, intentelo de nuevo");
                                    }

                                    break;
                                }
                                case 2:{
                                    menuSecundario2 = true;
                                    //Mostrar el tipon de una carta especificada.
                                    while(menuSecundario2){
                                        try{System.out.println("De donde quiere ver la carta?");
                                            System.out.println("1. Su coleccion");
                                            System.out.println("2. El maso de cartas.");
                                            int op2 = scan.nextInt();
                                            scan.nextLine();

                                            if(op2 == 1){
                                                System.out.println("\nIngrese el nombre de la carta que desea observar");
                                                String cartaElejida = scan.nextLine();

                                                if(coleccionUsuario.containsKey(cartaElejida)){
                                                    System.out.println("\nEl tipo de la carta " + cartaElejida + " es: " + coleccionUsuario.get(cartaElejida));
                                                    menuSecundario2 = false;

                                                }else{
                                                    System.out.println("\nLa carta " + cartaElejida + " no esta en la coleccion del usuario");
                                                    menuSecundario2 = false;
                                                }

                                            }else if(op2 == 2){
                                                System.out.println("\nIngrese el nombre de la carta que desea observar");
                                                String cartaElejida = scan.nextLine();

                                                if(cartas.containsKey(cartaElejida)){
                                                    System.out.println("\nEl tipo de la carta " + cartaElejida + " es: " + cartas.get(cartaElejida));
                                                    menuSecundario2 = false;

                                                }else{
                                                    System.out.println("\nLa carta " + cartaElejida + " no esta en el maso de cartas");
                                                    menuSecundario2 = false;
                                                }
                                            }

                                        }catch(InputMismatchException e){
                                            scan.nextLine();
                                            System.err.println("Se ingreso una opcion invalida, intentelo de nuevo");
                                        }

                                    }

                                    break;
                                }
                                case 3:{
                                    //Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección.

                                    contadorMonstruo = 0;
                                    contadorHechizo = 0;
                                    contadorTrampa = 0;
                                    System.out.println("");

                                    for (String key : coleccionUsuario.keySet())
                                    {


                                        switch (coleccionUsuario.get(key)) {
                                            case "Monstruo" -> contadorMonstruo++;
                                            case "Hechizo" -> contadorHechizo++;
                                            case "Trampa" -> contadorTrampa++;
                                        }
                                        System.out.println("Nombre: " + key + " | Tipo: " + coleccionUsuario.get(key));
                                    }
                                    System.out.println("\nCantidad de cartas tipo Monstruo: " + contadorMonstruo);
                                    System.out.println("Cantidad de cartas tipo Hechizo: " + contadorHechizo);
                                    System.out.println("Cantidad de cartas tipo Trampa: " + contadorTrampa);




                                    break;
                                }
                                case 4:{

                                    contadorMonstruo = 0;
                                    contadorHechizo = 0;
                                    contadorTrampa = 0;

                                    //Mostrarel nombre, tipo y cantidad de cada cartaque el usuario tiene en su colección, ordenadas por tipo.
                                    ArrayList<String> monstruos = new ArrayList<String>();
                                    ArrayList<String> hechizos = new ArrayList<String>();
                                    ArrayList<String> trampas = new ArrayList<String>();

                                    for (String key : coleccionUsuario.keySet())
                                    {
                                        switch (coleccionUsuario.get(key)) {
                                            case "Monstruo" :
                                                contadorMonstruo++;
                                                monstruos.add("Nombre: " + key + " | Tipo: " + coleccionUsuario.get(key));
                                                break;
                                            case "Hechizo":
                                                contadorHechizo++;
                                                hechizos.add("Nombre: " + key + " | Tipo: " + coleccionUsuario.get(key));
                                                break;
                                            case "Trampa":
                                                contadorTrampa++;
                                                trampas.add("Nombre: " + key + " | Tipo: " + coleccionUsuario.get(key));
                                                break;
                                        }

                                    }
                                    System.out.println("\nCantidad de cartas tipo Monstruo: " + contadorMonstruo);
                                    for (int i = 0; i < monstruos.size(); i++) {
                                        System.out.println(monstruos.get(i));
                                    }
                                    System.out.println("\nCantidad de cartas tipo Hechizo: " + contadorHechizo);
                                    for (int i = 0; i < hechizos.size(); i++) {
                                        System.out.println(hechizos.get(i));
                                    }
                                    System.out.println("\nCantidad de cartas tipo Trampa: " + contadorTrampa);
                                    for (int i = 0; i < trampas.size(); i++) {
                                        System.out.println(trampas.get(i));
                                    }


                                    break;
                                }
                                case 5:{
                                    //Mostrar el nombre y tipo de todas las cartas existentes.
                                    for (String key : cartas.keySet())
                                    {
                                        System.out.println("Nombre: " + key + " | Tipo: " + cartas.get(key));
                                    }
                                    for (String key : coleccionUsuario.keySet())
                                    {
                                        System.out.println("Nombre: " + key + " | Tipo: " + coleccionUsuario.get(key));
                                    }



                                    break;
                                }
                                case 6:{
                                    //Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.



                                    //Mostrarel nombre, tipo y cantidad de cada cartaque el usuario tiene en su colección, ordenadas por tipo.
                                    ArrayList<String> monstruos = new ArrayList<String>();
                                    ArrayList<String> hechizos = new ArrayList<String>();
                                    ArrayList<String> trampas = new ArrayList<String>();

                                    for (String key : coleccionUsuario.keySet())
                                    {
                                        switch (coleccionUsuario.get(key)) {
                                            case "Monstruo" :
                                                monstruos.add("Nombre: " + key + " | Tipo: " + coleccionUsuario.get(key));
                                                break;
                                            case "Hechizo":
                                                hechizos.add("Nombre: " + key + " | Tipo: " + coleccionUsuario.get(key));
                                                break;
                                            case "Trampa":
                                                trampas.add("Nombre: " + key + " | Tipo: " + coleccionUsuario.get(key));
                                                break;
                                        }

                                    }
                                    for (String key : cartas.keySet())
                                    {
                                        switch (cartas.get(key)) {
                                            case "Monstruo" :
                                                monstruos.add("Nombre: " + key + " | Tipo: " + cartas.get(key));
                                                break;
                                            case "Hechizo":
                                                hechizos.add("Nombre: " + key + " | Tipo: " + cartas.get(key));
                                                break;
                                            case "Trampa":
                                                trampas.add("Nombre: " + key + " | Tipo: " + cartas.get(key));
                                                break;
                                        }

                                    }
                                    System.out.println("\nCartas tipo Monstruo: ");
                                    for (int i = 0; i < monstruos.size(); i++) {
                                        System.out.println(monstruos.get(i));
                                    }
                                    System.out.println("\nCartas tipo Hechizo: ");
                                    for (int i = 0; i < hechizos.size(); i++) {
                                        System.out.println(hechizos.get(i));
                                    }
                                    System.out.println("\nCartas tipo Trampa: ");
                                    for (int i = 0; i < trampas.size(); i++) {
                                        System.out.println(trampas.get(i));
                                    }
                                    break;
                                }
                                case 7:{
                                    //Regresar al menu principal
                                    menuSecundario = false;

                                    break;
                                }
                                default:{
                                    //Opcion fuera de rango
                                    scan.nextLine();
                                    System.out.println("Se ingreso una opcion invalida, intentelo de nuevo.");
                                }
                            }

                        }catch(InputMismatchException e){
                            //Ingreso algo no int
                            scan.nextLine();
                            System.err.println("Se ingreso una opcion invalida, intentelo de nuevo");
                        }
                    }

                }else if(opcion == 4){
                    //Sale del programa
                    menuPrincipal = false;
                    System.out.println("Gracias por usar nuestro programa");


                } else{
                    //Opcion ingresada fuera de rango
                    System.out.println("Se ingreso una opcion invalida, intentelo de nuevo");
                }


            } catch(InputMismatchException e){
                //Ingreso algo no int
                scan.nextLine();
                System.err.println("Se ingreso una opcion invalida, intentelo de nuevo");

            }

        }

    }
}