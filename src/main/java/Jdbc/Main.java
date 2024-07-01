package Jdbc;
import Jdbc.dao.DAO_Person_Object_Implementation;
import Jdbc.database.databaseBridge;
import Jdbc.model.Person;

public class Main implements databaseBridge {

    public static void main(String[] args) {
        DAO_Person_Object_Implementation tmp_personDAO_object = new DAO_Person_Object_Implementation();

        /*
        Person tmpPerson = new Person();
        tmpPerson.setUser_name("Delariz");
        tmpPerson.setUser_email("DzAlchaviche68@gmail.com");
        tmp_personDAO_object.addPerson(tmpPerson);
         */

        tmp_personDAO_object.deletePerson(7);

        tmp_personDAO_object.getAllQuery();
    }
}



