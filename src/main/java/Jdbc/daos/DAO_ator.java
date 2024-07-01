package Jdbc.daos;
import Jdbc.database.databaseBridge;
import Jdbc.models.ator;
import Jdbc.services.DAO_Factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO_ator extends DAO_Factory {

    public static void insertAtor(ator parametro){
        try (Connection localConnection = databaseBridge.establishConnection()){
            String query = "INSERT INTO ator (nome) VALUES (?)";
            PreparedStatement ps = localConnection.prepareStatement(query);
            // Alterando parametros da query
            ps.setString(1, parametro.getNome());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void updateAtor(ator parametro){
        try(Connection localConnection = databaseBridge.establishConnection()){
            String query = "UPDATE ator SET nome = ? WHERE cod_ator = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ps.setString(1, parametro.getNome());
            ps.setInt(2, parametro.getCod_ator());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


}
