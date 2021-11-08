package paquete;
import java.sql.*;

public class ConsultarDB {

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

        //Se crea el ResultSet que almacenará la respuesta de la BD.
        ResultSet rs = sentencia.executeQuery("SELECT * FROM empleados WHERE salario > 1500");

        System.out.println("Empleados cuyo salario es mayor que 1500:");
        while (rs.next()) {
            System.out.println(" # Código: " + rs.getInt(1) + " - Nombre: " + rs.getString(2) + 
                    " - Apellidos: " + rs.getString(3) + " - Puesto: " + rs.getString(4) + " - Salario: " + rs.getInt(5));
        }

        //Se liberan los recursos.
        rs.close();
        sentencia.close();
        conexion.close();
    }
}
