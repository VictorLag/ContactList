import java.util.ArrayList;
import java.util.Scanner;

public class MainContactos {

    private static Scanner sc = new Scanner(System.in);
    private static Scanner sc2= new Scanner(System.in);


    public static void impirmenu() {

        System.out.println("0 = Salir");
        System.out.println("1 = Imprimir contactos");
        System.out.println("2 = Agregar nuevo contacto");
        System.out.println("3 = Actualizar contacto");
        System.out.println("4 = Eliminar contacto");
        System.out.println("5 = Buscar contacto por nombre");
        System.out.println("6 = Volver a imprimir las opciones");

    }

    public static void printContacts(){

        System.out.println("Estos son tus contactos:");
        telefonoMovil.printContacts();

    }

    public static void anadircontacto (){

        System.out.println("Añade el nombre del nuevo contacto");
        String nombrecase2=sc.next();

        System.out.println("Añade el numero del contacto");
        String numerocase2=sc2.next();



        if (telefonoMovil.queryContact(nombrecase2) == null){
            System.out.println("Añadiendo "+nombrecase2+ "--->" + numerocase2+" a tu lista de contactos");
            telefonoMovil.addNewContact(Contacto.createContact(nombrecase2,numerocase2));
        }
        else {
            System.out.println(nombrecase2+" ya existe en tu lista de contactos");
        }
    }
    public static void actualizarcontacto (){
        String nombrecase3="";
        String nuevonombre3="";
        String nuevonumerocase3="";


        System.out.println("Escribe el nombre del contacto que quiere actualizar");
        nombrecase3=sc.next();
        System.out.println("Seleccionaste a " + nombrecase3);
        if (telefonoMovil.queryContact(nombrecase3) !=null){

            System.out.println("Escribe el nuevo nombre de "+ nombrecase3);
            nuevonombre3=sc.next();

            System.out.println("Ahora escribe el nuevo numero de "+ nuevonombre3);
            nuevonumerocase3=sc.next();

            telefonoMovil.updateContact(telefonoMovil.queryContact(nombrecase3),Contacto.createContact(nuevonombre3,nuevonumerocase3));
            System.out.println("Se ha actualizado correctamente el contacto");
            printContacts();
        }
        else {
            System.out.println("El contacto que quiere actualizar no existe, revise su lista de contactos escribiendo 1");
        }

    }

    public static void quitarcontacto(){
        String nombreEliminar;

        System.out.println("Escribe el nombre del contacto que quiere eliminar");
        nombreEliminar=sc.next();
        if (telefonoMovil.queryContact(nombreEliminar)!=null){

            telefonoMovil.removeContact(telefonoMovil.queryContact(nombreEliminar));
            System.out.println("Se ha eliminado a "+ nombreEliminar+ " de tu lista de contactos");
        }
        else{
            System.out.println(nombreEliminar+ " no existe en tu lista de contactos");
        }
    }

    public static void buscarContacto(){

        String nombrebuscar;

        System.out.println("Escribe el nombre del contacto que buscas");
        nombrebuscar=sc.next();

        if (telefonoMovil.queryContact(nombrebuscar)!=null){

            System.out.println(telefonoMovil.queryContact(nombrebuscar).getName()+"--->"+telefonoMovil.queryContact(nombrebuscar).getPhoneNumber() );
        }
        else {
            System.out.println("No se ha encontrado el contacto");
        }

    }


    private static TelefonoMovil telefonoMovil= new TelefonoMovil("123456789");


    public static void main(String[] args) {

        boolean continuar = true;
        int opcion;
        impirmenu();

        while (continuar){

            System.out.println("Elige una opcion.");
            opcion=sc.nextInt();


            switch (opcion){

                case 0: //Salir del programa
                    System.out.println("Adios");
                    continuar=false;
                    break;

                case 1: //Imprimir todos los contactos que existen
                    printContacts();
                    break;

                case 2: // Añadir contacto
                    anadircontacto();
                    break;

                case 3: //Actualizar contacto
                    actualizarcontacto();
                    break;

                case 4: // Quitar un contacto

                    quitarcontacto();
                   break;

                case 5:  //busca contacto por nombre

                    buscarContacto();
                    break;


            }



        }


    }





}
