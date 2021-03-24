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
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.util.stream.Collectors;

public class Menu {

    public static void main(String args[]){
        Instance factory = new Instance();
        Scanner scan = new Scanner(System.in);

        HashMap<String, String> cartas = new HashMap<String, String>();
        Map<String, String> coleccionUsuario ;
        boolean menuPrincipal = true;

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

            for (String key : cartas.keySet())
            {
                System.out.println(cartas.get(key) + "|" + key);
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
                            System.out.println("4. Mostrarel nombre, tipo y cantidad de cada cartaque el usuario tiene en su colección, ordenadas por tipo.");
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
                                    //Mostrar el tipon de una carta especificada.
                                    System.out.println("Ingrese el nombre de la carta que desea observar");
                                    String cartaElejida = scan.nextLine();
                                    System.out.println("El tipo de la carta " + cartaElejida + " es: " + cartas.get(cartaElejida));

                                    System.out.println(2);

                                    break;
                                }
                                case 3:{
                                    //Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección.

                                    for (String key : coleccionUsuario.keySet())
                                    {
                                        int cantidad;
                                        System.out.println("Nombre: " + coleccionUsuario.get(key) + " | Tipo: " + key);
                                    }




                                    break;
                                }
                                case 4:{
                                    //Mostrarel nombre, tipo y cantidad de cada cartaque el usuario tiene en su colección, ordenadas por tipo.
                                    System.out.println("Ingrese el nombre de la carta que desea contar");
                                    String element = scan.nextLine();
                                    int count = 0;


                                    for (Map.Entry<String, String> entry : cartas.entrySet())
                                    {

                                        element = entry.getValue();

                                        // extraer la cantidad de veces que existe la clave
                                        // si no existe la clave se retorna 0 por defecto
                                        // incrementar la cuenta
                                        count++;


                                    }
                                    System.out.println("La carta "+element+" ha aparecido: "+count+" veces");

                                    System.out.println(4);



                                    break;
                                }
                                case 5:{
                                    //Mostrar el nombre y tipo de todas las cartas existentes.
                                    System.out.println(5);



                                    break;
                                }
                                case 6:{
                                    //Mostrar el nombre y tipo de todas las cartas existentes.
                                    System.out.println(6);



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
