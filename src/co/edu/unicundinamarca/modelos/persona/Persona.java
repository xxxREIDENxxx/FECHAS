package co.edu.unicundinamarca.modelos.persona;

import java.util.Date;
//clasee persona
public class Persona {
	
    private int id = 0,documento,edad;
    private String  nombre, 
                    Apellido,
                    tipoPersona;
    private String fechaNacimiento;
    //constructor
    public  Persona(int id, int documento, String nombre, String apellido, String fechaNacimiento, int edad, String tipoPersona) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.Apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.tipoPersona = tipoPersona;
    }
    //metodod para recibir y enviar
    public static Persona crear(int id, int documento, String nombre, String apellido, String fechaNacimiento, int edad, String tipoPersona) {
        return new Persona(id, documento, nombre, apellido, fechaNacimiento, edad, tipoPersona);
    }

    /**
     * metodos gett y sett
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the documento
     */
    public int getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the tipoPersona
     */
    public String getTipoPersona() {
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}