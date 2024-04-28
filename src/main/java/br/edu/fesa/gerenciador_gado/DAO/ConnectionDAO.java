/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.gerenciador_gado.DAO;

import br.edu.fesa.gerenciador_gado.exception.PersistenceException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *

 * @author paulo
 * @author lohan
 * @author Rodrigo Puertas

 */
public class ConnectionDAO {
    private final ResourceBundle BUNDLE = ResourceBundle.getBundle("br.edu.fesa.gerenciador_gado.dbconfig.connection", new Locale("pt", "BR"));
    private static ConnectionDAO conexao;

    private ConnectionDAO() {

    }

    public static ConnectionDAO getConexao() {
        if (conexao == null) {
            conexao = new ConnectionDAO();
        }
        return conexao;
    }

    public Connection getConnection() throws PersistenceException {
        Connection connection = null;
        try {
            Class.forName(BUNDLE.getString("driver"));
            connection = DriverManager.getConnection(BUNDLE.getString("url"), BUNDLE.getString("usuario"), BUNDLE.getString("senha"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Erro ao carregar a conexão com o banco de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível realizar a operação no banco de dados!");
        }
         return connection;
    }
}
