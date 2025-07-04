package org.example;

import java.sql.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:mysql://localhost:3306/aula1";
        String user = "root";
        String password = "a";

        // Conexão
        try (

                Connection conn = DriverManager.getConnection(url, user, password)) {
                if (conn != null) {
                    System.out.println("Conexão estabelecida com sucesso!");
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM ESTUDANTE");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){//iterator
                       String nome =  rs.getString("NOME");
                        System.out.println(nome);
                    }
                    conn.close();
                }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao conectar no banco: " + e.getMessage());

        }
        System.exit(0);

    }
}
