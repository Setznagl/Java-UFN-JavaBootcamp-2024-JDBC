package Jdbc.daos;

import Jdbc.database.databaseBridge;
import Jdbc.models.categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_categoria {

    public static void insertCategoria(categoria parametro) {
        try (Connection localConnection = databaseBridge.establishConnection();) {
            String query = "INSERT INTO categoria (nome , valor) VALUES (? , ?)";
            PreparedStatement ps = localConnection.prepareStatement(query);
            // Alterando parametros da query
            ps.setString(1, parametro.getNome());
            ps.setDouble(2, parametro.getValor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static categoria readCategoria(int id) {
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "SELECT * FROM categoria WHERE cod_cat = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                categoria result = new categoria(rs.getInt("cod_cat"), rs.getString("nome"), rs.getFloat("valor"));
                System.out.println(result);
                return result;
            } else {
                throw new SQLException("Category not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<categoria> readAllCategoria() {
        var return_list = new ArrayList<categoria>();
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "SELECT * FROM categoria";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    int cod_cat = rs.getInt("cod_cat");
                    String nome = rs.getString("nome");
                    float valor = rs.getFloat("valor");
                    return_list.add(new categoria(cod_cat, nome, valor));
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(return_list);
        return return_list;
    }

    public static void updateCategoria(categoria parametro) {
        try (Connection localConnection = databaseBridge.establishConnection();) {
            String query = "UPDATE categoria SET (nome , valor) = (? , ?) WHERE cod_cat = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
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
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "DELETE FROM categoria WHERE cod_cat = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ps.setInt(1, parametro.getCod_cat());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


}
