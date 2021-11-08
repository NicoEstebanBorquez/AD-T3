package paquete;
import java.sql.*;

public class InsertarDB {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Se carga el driver.
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Se abre la conexión con la BD.
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ad_tarea3", "root", "");

        //Se comprueba que la conexión esté en autocommit.
        if (!conexion.getAutoCommit()) {
            conexion.setAutoCommit(true);
            System.out.println("Commit automático activado.");
        }
        
        //Se crea la sentencia.
        Statement sentencia = conexion.createStatement();
        
        //Se lanzan las sentencias.
        int filas = 0;
        filas = filas + sentencia.executeUpdate("INSERT INTO empleados(codEmpleado, nombre, apellidos, puesto, salario) "
                + "VALUES (1, 'Nicolas', 'Esteban Borquez', 'Desarrollador', 1750)");
        filas = filas + sentencia.executeUpdate("INSERT INTO empleados(codEmpleado, nombre, apellidos, puesto, salario) "
                + "VALUES (2, 'Manuel', 'Martínez', 'Contable', 1200)");
        filas = filas + sentencia.executeUpdate("INSERT INTO empleados(codEmpleado, nombre, apellidos, puesto, salario) "
                + "VALUES (3, 'Silvia', 'Marzo', 'Desarrolladorr', 1600)");
        filas = filas + sentencia.executeUpdate("INSERT INTO empleados(codEmpleado, nombre, apellidos, puesto, salario) "
                + "VALUES (4, 'Miguel', 'Cerezo', 'Analista', 1500)");
        filas = filas + sentencia.executeUpdate("INSERT INTO empleados(codEmpleado, nombre, apellidos, puesto, salario) "
                + "VALUES (5, 'Sara', 'Toro', 'Gerente', 1800)");
        
        System.out.println("Se han insertado " + filas + " filas.");
        
        //Se liberan los recursos.
        sentencia.close();
        conexion.close();
    }
}
