package co.edu.unicundinamarca.modelos.persona;

import co.edu.unicundinamarca.database.DBManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Repositorio {
    DateFormat tf = DateFormat.getDateInstance();
    private static DBManager database = new DBManager();
    //metodo de crear persona
    public static void crear (Persona persona) {
        
        try {
            String query = "INSERT INTO formulariopersona (documento, nombre, apellido, fechaNacimiento, edad, tipoPersona) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, Integer.toString(persona.getDocumento()));
            sentenciaP.setString(2, persona.getNombre());
            sentenciaP.setString(3, persona.getApellido());
            sentenciaP.setString(4, persona.getFechaNacimiento());
            sentenciaP.setString(5, Integer.toString(persona.getEdad()));
            sentenciaP.setString(6, persona.getTipoPersona());
            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    
    //nmetodo de editar
    public static void editar (Persona persona) {
        
        try {
            //convertirFechaString(persona.getFechaNacimiento());
            String query = "UPDATE formulariopersona SET documento = ?, nombre = ?, apellido = ?, fechaNacimiento = ?, edad = ?, tipoPersona = ? WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, Integer.toString(persona.getDocumento()));
           sentenciaP.setString(2, persona.getNombre());
            sentenciaP.setString(3, persona.getApellido());
            sentenciaP.setString(4, persona.getFechaNacimiento());
            sentenciaP.setString(5, Integer.toString(persona.getEdad()));
            sentenciaP.setString(6, persona.getTipoPersona());
            sentenciaP.setString(7, Integer.toString(persona.getId()));

            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //metodo de cpomvertir
    public static String convertirFechaString(Date date){
	
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
	
        return formatter.format(date);
	
    }
    //metodo de eliminar
    public static void eliminar (Persona persona) {
        try {
            String query = "DELETE FROM formulariopersona WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, Integer.toString(persona.getId()));

            sentenciaP.execute();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //metodo de obtener
    public static Persona obtener(int id) {
        try {
            String query = "SELECT * FROM formulariopersona WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, Integer.toString(id));

            ResultSet resultado = sentenciaP.executeQuery();

            sentenciaP.close();
            database.close();

            while (resultado.next()) {
                return Persona.crear(resultado.getInt("id"), resultado.getInt("documento"), resultado.getString("nombre"), resultado.getString("apellido"), resultado.getString("fechaNacimiento"), resultado.getInt("edad"), resultado.getString("tipoPersona"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    
    //metodo buscar
    public static Persona buscar(String documento) {
        try {
            String query = "SELECT * FROM formulariopersona WHERE documento = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, documento);

            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                return Persona.crear(resultado.getInt("id"), resultado.getInt("documento"), resultado.getString("nombre"), resultado.getString("apellido"), resultado.getString("fechaNacimiento"), resultado.getInt("edad"), resultado.getString("tipoPersona"));
            }
            
            sentenciaP.close();
            database.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    //metodo obtener datos
    public static ArrayList<Persona> obtenerTodos() {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        try {
            String query = "SELECT * FROM formulariopersona;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                personas.add(Persona.crear(resultado.getInt("id"), resultado.getInt("documento"), resultado.getString("nombre"), resultado.getString("apellido"), resultado.getString("fechaNacimiento"), resultado.getInt("edad"), resultado.getString("tipoPersona")));
            }

            sentenciaP.close();
            database.close();

            return personas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return personas;
    }
}
