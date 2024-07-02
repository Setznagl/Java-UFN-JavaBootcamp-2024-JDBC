package Jdbc.daos;
import Jdbc.database.databaseBridge;
import Jdbc.models.categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_categoria {

    public static void createCategoria(categoria parametro) {
        try (Connection localConnection = databaseBridge.establishConnection();) {
            String query = "INSERT INTO categoria (nome , valor) VALUES (? , ?)";
            PreparedStatement ps = localConnection.prepareStatement(query);
            //set strings
            ps.setString(1, parametro.getNome());
            ps.setDouble(2, parametro.getValor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static categoria readCategoria(int id){
        try(Connection localConnection = databaseBridge.establishConnection()){
            String query = "SELECT * FROM categoria WHERE cod_cat = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new categoria(rs.getInt("cod_cat"),
                        rs.getString("nome"), rs.getFloat("valor"));
            } else {
                throw new SQLException("Actor not found");
            }

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void updateCategoria(categoria parametro) {
        try (Connection localConnection = databaseBridge.establishConnection();) {
            String query = "UPDATE categoria SET (nome , valor) = (? , ?) WHERE cod_cat = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            //set strings
            ps.setString(1, parametro.getNome());
            ps.setDouble(2, parametro.getValor());
            ps.setInt(3, parametro.getCod_cat());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void deleteCategoria(categoria parametro) {
        try(Connection localConnection = databaseBridge.establishConnection()){
            String query = "DELETE FROM categoria WHERE cod_cat = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ps.setInt(1, parametro.getCod_cat());
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
