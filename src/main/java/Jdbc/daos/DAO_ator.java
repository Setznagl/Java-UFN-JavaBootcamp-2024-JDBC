package Jdbc.daos;

import Jdbc.database.databaseBridge;
import Jdbc.models.ator;
import Jdbc.services.DAO_Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_ator extends DAO_Factory {

    public static void insertAtor(ator parametro) {
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "INSERT INTO ator (nome) VALUES (?)";
            PreparedStatement ps = localConnection.prepareStatement(query);
            // Alterando parametros da query
            ps.setString(1, parametro.getNome());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static ator readAtor(int id) {
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "SELECT * FROM ator WHERE cod_ator = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ator result = new ator(rs.getInt("cod_ator"), rs.getString("nome"));
                System.out.println(result);
                return result;
            } else {
                throw new SQLException("Actor not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<ator> readAllAtor() {
        var return_list = new ArrayList<ator>();
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "SELECT * FROM ator";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    int cod_ator = rs.getInt("cod_ator");
                    String nome = rs.getString("nome");
                    return_list.add(new ator(cod_ator, nome));
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(return_list);
        return return_list;
    }

    public static void updateAtor(ator parametro) {
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "UPDATE ator SET nome = ? WHERE cod_ator = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ps.setString(1, parametro.getNome());
            ps.setInt(2, parametro.getCod_ator());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void deleteAtor(ator parametro) {
        try (Connection localConnection = databaseBridge.establishConnection()) {
            String query = "DELETE FROM ator WHERE cod_ator = ?";
            PreparedStatement ps = localConnection.prepareStatement(query);
            ps.setInt(1, parametro.getCod_ator());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
