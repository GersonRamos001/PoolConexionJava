/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testconexionpool;
import java.sql.*;
import modelo.PoolConexion;

/**
 *
 * @author ramos
 */
public class TestConexionPool {
    
    public static void main(String[] args) throws SQLException {
        //test

        Connection conn = PoolConexion.getInstance().getConexion();
        for (int i = 0; i < 100100; i++) {
            if(conn != null){
            System.out.println("Conexion Exitosa" +i);
            PoolConexion.getInstance().closeConexion(conn);
                System.out.println(PoolConexion.getInstance().traerDatos());
        }else{
            System.out.println("Error en conexion" + i);
        }
            
        }
        
    }
    
}
