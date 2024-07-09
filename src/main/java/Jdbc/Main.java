package Jdbc;
import Jdbc.database.databaseBridge;
import Jdbc.services.Menu;

public class Main implements databaseBridge , Menu {

    public static void main(String[] args) {

        // Selecionar tabela que será afetada
        int choiceTable = Menu.selectTable();

        // Selecionar função que será usada
        int choiceFunction = Menu.selectFunction();

        // Chamar a flow tree
        Menu.flowTree(choiceTable, choiceFunction);
    }
}



