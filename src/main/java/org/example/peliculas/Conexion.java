package org.example.peliculas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {


        public static void main(String[] args) {


            // Ruta donde tienes el wallet (con tnsnames.ora, sqlnet.ora, cwallet.sso, etc.)
            String ubicacionWallet = "\\PELICULAS\\src\\wallet";

            // Configuras la propiedad para que Oracle JDBC use el TNS admin en esa carpeta
            System.setProperty("oracle.net.tns_admin", ubicacionWallet);

            // Cadena JDBC usando el alias TNS definido en tnsnames.ora (sin errores)
            String jdbcurl = "jdbc:oracle:thin:@practica_high";

            // Usuario y contraseña de tu Autonomous Database
            String userName = "";
            String password = "";

            try {
                // Carga el driver de Oracle
                Class.forName("oracle.jdbc.OracleDriver");

                // Establece conexión
                Connection con = DriverManager.getConnection(jdbcurl, userName, password);
                System.out.println("Conexión establecida correctamente.");

                // Crea una sentencia para ejecutar SQL
                Statement stmt = con.createStatement();

                // Ejecuta una consulta SELECT simple a la tabla AUTORES
                ResultSet rs = stmt.executeQuery("SELECT * FROM AUTORES");

                // Imprime los resultados
                while (rs.next()) {
                    System.out.println(rs.getString(1)); // imprime la primera columna (ajusta según tabla)
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                }

                // Cierra recursos
                rs.close();
                stmt.close();
                con.close();

            } catch (Exception e) {
                System.out.println("Error: conexión no establecida.");
                e.printStackTrace();
            }
        }
    }

