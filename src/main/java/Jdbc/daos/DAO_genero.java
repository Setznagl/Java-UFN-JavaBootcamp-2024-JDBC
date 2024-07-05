package Jdbc.daos;
import Jdbc.database.databaseBridge;
import Jdbc.models.genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_genero {

    public static void insertGenero(genero parametro) {
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "INSERT INTO genero (nome) VALUES (?)";
            PreparedStatement ps = localConnection.prepareStatement(query);
            // Alterando parametros da query
            ps.setString(1, parametro.getNome());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static genero readGenero(int id) {
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "SELECT * FROM genero WHERE cod_gen = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                genero result = new genero(rs.getInt("cod_gen"), rs.getString("nome"));
                System.out.println(result);
                return result;
            } else {
                throw new SQLException("Genero not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<genero> readAllgenero() {
        var return_list = new ArrayList<genero>();
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "SELECT * FROM genero";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    int cod_gen = rs.getInt("cod_gen");
                    String nome = rs.getString("nome");
                    return_list.add(new genero(cod_gen, nome));
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(return_list);
        return return_list;
    }

    public static void updateAtor(genero parametro) {
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "UPDATE genero SET nome = ? WHERE cod_gen = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ps.setString(1, parametro.getNome());
            ps.setInt(2, parametro.getCod_gen());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void deleteAtor(genero parametro) {
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "DELETE FROM genero WHERE cod_gen = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ps.setInt(1, parametro.getCod_gen());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
