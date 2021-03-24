import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    public static void main(String args[]){
        Instance factory = new Instance();
        Scanner scan = new Scanner(System.in);

        Map<String, String> hola;
        boolean menuPrincipal = true;

        while(menuPrincipal){
            boolean menuSecundario = true;
            try{
                System.out.println("\nMenu Principal");
                System.out.println("1. HashMap");
                System.out.println("2. LinkedHashMap");
                System.out.println("3. TreeMap");
                System.out.println("4. Salir\n");

                int opcion = scan.nextInt();

                if(opcion >= 1 && opcion <= 3){
                    //Crea el Mapa de la opcion elegida
                    hola = factory.getInstance(opcion);

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

                            switch(eleccion){
                                case 1:{
                                    //Agregar una carta a la collecion del usuario.
                                    System.out.println(1);



                                    break;
                                }
                                case 2:{
                                    //Mostrar el tipon de una carta especificada.
                                    System.out.println(2);



                                    break;
                                }
                                case 3:{
                                    //Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección.
                                    System.out.println(3);



                                    break;
                                }
                                case 4:{
                                    //Mostrarel nombre, tipo y cantidad de cada cartaque el usuario tiene en su colección, ordenadas por tipo.
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
