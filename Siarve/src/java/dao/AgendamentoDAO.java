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
import model.Agendamento;

public class AgendamentoDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/siarve?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_AGENDAMENTO_SQL = "insert into agendamentos (nome, rne, codigo, data_agendamento) values (?,?,?,?)";
    private static final String SELECT_AGENDAMENTO_BY_ID = "select id,nome,rne,codigo,data_agendamento from agendamentos where id =?";
    private static final String SELECT_ALL_AGENDAMENTO = "select * from agendamentos";
    private static final String DELETE_AGENDAMENTO_SQL = "delete from agendamentos where id = ?;";
    private static final String UPDATE_AGENDAMENTO_SQL = "update agendamentos set nome = ?,rne= ?, codigo =?, data_agendamento =? where id = ?;";

    public AgendamentoDAO() {
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

    public void insertAgendamento(Agendamento agendamento) throws SQLException {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AGENDAMENTO_SQL)) {
            preparedStatement.setString(1, agendamento.getNome());
            preparedStatement.setString(2, agendamento.getRne());
            preparedStatement.setString(3, agendamento.getCodigo());
            preparedStatement.setString(4, agendamento.getDataAgendamento());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Agendamento selectAgendamento(int id) {
        Agendamento agendamento = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AGENDAMENTO_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String rne = rs.getString("rne");
                String codigo = rs.getString("codigo");
                String data_agendamento = rs.getString("data_agendamento");
                agendamento = new Agendamento(id, nome, rne, codigo, data_agendamento);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return agendamento;
    }

    public List<Agendamento> selectAllEstudante() {

        List<Agendamento> agendamento = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AGENDAMENTO);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String rne = rs.getString("rne");
                String codigo = rs.getString("codigo");
                String data_agendamento = rs.getString("data_agendamento");
                agendamento.add(new Agendamento(id, nome, rne, codigo, data_agendamento));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return agendamento;
    }

    public boolean deleteAgendamento(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_AGENDAMENTO_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateEstudante(Agendamento agendamento) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_AGENDAMENTO_SQL);) {
            statement.setString(1, agendamento.getNome());
            statement.setString(2, agendamento.getRne());
            statement.setString(3, agendamento.getCodigo());
            statement.setString(4, agendamento.getDataAgendamento());
            statement.setInt(5, agendamento.getId());
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
