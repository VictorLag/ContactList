import java.util.ArrayList;

public class TelefonoMovil {

    public ArrayList<Contacto> myContacts=new ArrayList<Contacto>();
    private String myNumber;
    public boolean existe;


    public boolean addNewContact (Contacto contacto){

        existe=true;

        if (findContact(contacto)>-1){
            existe=false;
        }
        else {
            myContacts.add(contacto);
        }

        return existe; //Si el contacto que se añade ya existe = false
    }

    public boolean updateContact (Contacto contactoAntiguo, Contacto contactoNuevo){

        boolean yaExiste=false;

        if (findContact(contactoAntiguo)>-1){
            yaExiste=true;
            myContacts.set(findContact(contactoAntiguo),contactoNuevo);
        }

        return yaExiste; //si el contacto no existe = false
    }


    public boolean removeContact (Contacto contacto){

        if (findContact(contacto)>-1){
            myContacts.remove(findContact(contacto));

            return true;
        }

        return false; //Si el contacto existe y se puede quitar = true
    }

    private int findContact (Contacto contacto){

        if (myContacts.contains(contacto)) {
            return this.myContacts.indexOf(contacto); //Sirve para comparar dos contactos
        }
        else
            return -1;

    }

    private int findContact(String contacto){



        for (int cont=0;cont< myContacts.size();cont++){

            if (myContacts.get(cont).getName().equalsIgnoreCase(contacto)){

                return cont;
            }
        }
        return -1; // Si = true ha encontrado el contacto en la lista

    }

    public Contacto queryContact (String nombrec){

        int posicion= findContact(nombrec);

        if (posicion>-1){
            return myContacts.get(posicion);
        }
        return null;
    }

    public void printContacts (){

        for (int cont=0;cont< myContacts.size();cont++){

            System.out.println(cont+1+". "+ myContacts.get(cont).getName()+"--->"+myContacts.get(cont).getPhoneNumber());

        }
    }

    public TelefonoMovil (String myNumber){

        this.myNumber=myNumber;

        ArrayList myContacts=new ArrayList<Contacto>();
        this.myContacts=myContacts;

    }
}
