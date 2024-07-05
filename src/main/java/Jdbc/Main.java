package Jdbc;
import Jdbc.daos.DAO_ator;
import Jdbc.daos.DAO_categoria;
import Jdbc.daos.DAO_genero;
import Jdbc.database.databaseBridge;
import Jdbc.services.DAO_Factory;
import Jdbc.services.Menu;

public class Main implements databaseBridge , Menu {

    public static void main(String[] args) {
        DAO_ator a = DAO_Factory.create_DAO_ator();
        DAO_categoria b = DAO_Factory.create_DAO_categoria();
        DAO_genero c = DAO_Factory.create_DAO_genero();

       int choiceTable = Menu.selectTable();
        System.out.println(choiceTable);

       int choiceFunction = Menu.selectFunction();
        System.out.println(choiceFunction);
    }
}



