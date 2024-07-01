package Jdbc;
import Jdbc.daos.DAO_ator;
import Jdbc.database.databaseBridge;
import Jdbc.models.ator;
import Jdbc.services.DAO_Factory;

public class Main implements databaseBridge {

    public static void main(String[] args) {
        DAO_ator a = DAO_Factory.create_DAO_ator();

        ator ator1 = new ator();

        ator1.setNome("Dromedário 3");
        ator1.setCod_ator(9);
        System.out.println(ator1);
        a.updateAtor(ator1);
            /*
        a.deleteAtor(2);
        a.getAllQuery();
             */
    }
}



