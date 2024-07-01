package Jdbc;
import Jdbc.daos.DAO_ator;
import Jdbc.database.databaseBridge;
import Jdbc.models.ator;
import Jdbc.services.DAO_Factory;

public class Main implements databaseBridge {

    public static void main(String[] args) {
        DAO_ator a = DAO_Factory.create_DAO_ator();

        ator ator1 = new ator();
        ator1.setUser_name("Golias");

        a.insertAtor(ator1);
        a.deleteAtor(2);
        a.getAllQuery();
    }
}



