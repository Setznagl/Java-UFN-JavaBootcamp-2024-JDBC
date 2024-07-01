package Jdbc.daos;
import Jdbc.database.databaseBridge;
import Jdbc.models.categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO_categoria {

    public static void inserirCategoria(categoria parametro) {
        try (Connection localConnection = databaseBridge.establishConnection();) {
            String query = "INSERT INTO categoria (nome , valor) VALUES (? , ?)";
            PreparedStatement ps = localConnection.prepareStatement(query);
            //set strings
            ps.setString(1, parametro.getNome());
            ps.setDouble(2, parametro.getValor());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
