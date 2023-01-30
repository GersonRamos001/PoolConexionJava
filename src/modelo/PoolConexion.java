/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author ramos
 */
public class PoolConexion {

    private final String BaseDatos = "crud_datos";
    private final String url = "jdbc:mysql://localhost:3306/" + this.BaseDatos;
    private final String usuario = "test";
    private final String pass = "Killer001";

    private static PoolConexion dataSource;
    private BasicDataSource basicDataSource = null;

    private PoolConexion() {
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(usuario);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);

        //Configuraciones opcionales
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(500);
        basicDataSource.setMaxWaitMillis(1000);
    }

    //metodo para instanciar esta clase, solo instanciar una y no mas
    public static PoolConexion getInstance() {
        if (dataSource == null) {
            dataSource = new PoolConexion();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    //Metodo para obtener una conexion
    public Connection getConexion() throws SQLException {
        return this.basicDataSource.getConnection();
    }

    //Metodod para cerrar la conexion
    public void closeConexion(Connection conn) throws SQLException {
        conn.close();
    }

    public Estudiante traerDatos() {
        String sql = "SELECT * FROM estudiante where id = 1";
        Statement st;
        String id;
        String apellido;
        String email;
        String nombre;
        
        
        try {
            st = this.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getString(1);
                apellido = rs.getString(2);
                email = rs.getString(3);
                nombre = rs.getString(4);


                Estudiante estudiante = new Estudiante(id,apellido,email ,nombre );
          
                return estudiante;
            }

        } catch (SQLException e) {
            System.err.println("error" + e.getMessage());

            return null;
        }
        return null;

    }

}
