package paquete;
import java.sql.*;

public class CrearDB {

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

        //Se lanza la sentencia.
        sentencia.executeUpdate("CREATE TABLE empleados ("
                + "codEmpleado INT PRIMARY KEY, "
                + "nombre VARCHAR(60), "
                + "apellidos VARCHAR(120), "
                + "puesto VARCHAR(50), "
                + "salario FLOAT(6,2));");
        
        System.out.println("Se ha creado la tabla 'Empleados'");

        //Se liberan los recursos.
        sentencia.close();
        conexion.close();
    }
}
