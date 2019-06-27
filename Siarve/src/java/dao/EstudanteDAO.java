/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author carlosfernandes
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Estudante;

public class EstudanteDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/siarve?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_Estudante_SQL = "insert into estudantes (nome, rne, passaport, pais, endereco_atual, data_entrada) values (?,?,?,?,?,?)";

    private static final String SELECT_Estudante_BY_ID = "select id,nome,rne,passaport,pais,endereco_atual,data_entrada from estudantes where id =?";
    private static final String SELECT_ALL_Estudante = "select * from estudantes";
    private static final String DELETE_Estudante_SQL = "delete from estudantes where id = ?;";
    private static final String UPDATE_Estudante_SQL = "update estudantes set nome = ?,rne= ?, passaport =?, pais =?, endereco_atual =?, data_entrada =? where id = ?;";

    public EstudanteDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertEstudante(Estudante estudante) throws SQLException {
        System.out.println(INSERT_Estudante_SQL);
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Estudante_SQL)) {
            preparedStatement.setString(1, estudante.getNome());
            preparedStatement.setString(2, estudante.getRne());
            preparedStatement.setString(3, estudante.getPassaport());
            preparedStatement.setString(4, estudante.getPais());
            preparedStatement.setString(5, estudante.getEndereco_atual());
            preparedStatement.setString(6, estudante.getData_entrada());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Estudante selectEstudante(int id) {
        Estudante estudante = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Estudante_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String rne = rs.getString("rne");
                String passaport = rs.getString("passaport");
                String pais = rs.getString("pais");
                String endereco_atual = rs.getString("endereco_atual");
                String data_entrada = rs.getString("data_entrada");
                estudante = new Estudante(id, nome, rne, passaport, pais, endereco_atual, data_entrada);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return estudante;
    }

    public List<Estudante> selectAllEstudante() {

        List<Estudante> estudantes = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Estudante);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String rne = rs.getString("rne");
                String passaport = rs.getString("passaport");
                String pais = rs.getString("pais");
                String endereco_atual = rs.getString("endereco_atual");
                String data_entrada = rs.getString("data_entrada");
                estudantes.add(new Estudante(id, nome, rne, passaport, pais, endereco_atual, data_entrada));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return estudantes;
    }

    public boolean deleteEstudante(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_Estudante_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateEstudante(Estudante estudante) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_Estudante_SQL);) {
            statement.setString(1, estudante.getNome());
            statement.setString(2, estudante.getRne());
            statement.setString(3, estudante.getPassaport());
            statement.setString(4, estudante.getPais());
            statement.setString(5, estudante.getEndereco_atual());
            statement.setString(6, estudante.getData_entrada());
            statement.setInt(7, estudante.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
