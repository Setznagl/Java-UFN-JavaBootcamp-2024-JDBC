package Jdbc.services;
import Jdbc.daos.DAO_ator;

public class DAO_Factory {
    public static DAO_ator create_DAO_ator(){
        return new DAO_ator();
    }
}
