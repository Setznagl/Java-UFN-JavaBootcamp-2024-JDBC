package Jdbc.dao;
import Jdbc.database.databaseBridge;
import Jdbc.model.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Person_Object_Implementation implements DAO_Person_Factory {

    @Override
    public int addPerson(Person p) {
        final Connection localConnection = databaseBridge.establishConnection();
        String query = "INSERT INTO person (name, email) VALUES (?, ?)";
        if (localConnection != null) {
            try (localConnection) {
                PreparedStatement ps = localConnection.prepareStatement(query);
                // PS setstring muda o valor para os parâmetros com ?
                ps.setString(1, p.getUser_name());
                ps.setString(2, p.getUser_email());
                return ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
            }
        } else {
            System.out.println("Falha ao se conectar com o banco de dados");
        }
        return 0;
    }

    @Override
    public int updatePerson(Person p) {
        final Connection localConnection = databaseBridge.establishConnection();
        String query = "UPDATE person SET name = ?, email = ? WHERE personid = ?";
        if (localConnection != null) {
            try (localConnection) {
                PreparedStatement ps = localConnection.prepareStatement(query);
                ps.setString(1, p.getUser_name());
                ps.setString(2, p.getUser_email());
                ps.setInt(3, p.getUser_id());
                return ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
            }
        } else {
            System.out.println("Falha ao se conectar com o banco de dados");
        }
        return 0;
    }

    @Override
    public int deletePerson(int id) {
        final Connection localConnection = databaseBridge.establishConnection();
        String query = "DELETE FROM person WHERE personid = ?";
        if (localConnection != null) {
            try (localConnection) {
                PreparedStatement ps = localConnection.prepareStatement(query);
                ps.setInt(1, id);
                return ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
            }
        } else {
            System.out.println("Falha ao se conectar com o banco de dados");
        }
        return 0;
    }

    @Override
    public void getPerson(int id) {
        final Connection localConnection = databaseBridge.establishConnection();
        String query = "SELECT * FROM person WHERE personid = ?";
        if (localConnection != null) {
            try (localConnection) {
                PreparedStatement ps = localConnection.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
            }
        } else {
            System.out.println("Falha ao se conectar com o banco de dados");
        }
    }

    @Override
    public void getAllQuery() {
        Connection localConnection = databaseBridge.establishConnection();
        String query = "SELECT * FROM person";
        if (localConnection != null) {
            try (PreparedStatement ps = localConnection.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString("name") + " " + rs.getString("email"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
            }
        } else {
            System.out.println("Falha ao se conectar com o banco de dados");
        }
    }
}
