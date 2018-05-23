package programacion.proyecto.cristian.seller;

public class Nombres {
    public static final String CAMPO_IDENTIFICADOR = "id";
    public static final String CAMPO_NOMBRE_NEGOCIO = "nombre_negocio";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_APELLIDO = "apellido";
    public static final String CAMPO_CEDULA = "cedula";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CAMPO_DIRECCION = "direccion";
    public static final String TABLA_CLIENTES = "clientes";
    public static final String BORRAR_TABLA = "DROP TABLE IF EXISTS "+ TABLA_CLIENTES;

    public static final String CREAR_TABLA = "CREATE TABLE " + TABLA_CLIENTES + "("+CAMPO_IDENTIFICADOR+" INTEGER AUTOINCREMENT," +
            ""+CAMPO_NOMBRE_NEGOCIO+" TEXT, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_APELLIDO+" TEXT, "+CAMPO_CEDULA+" TEXT, "+CAMPO_TELEFONO+" TEXT, " +
            ""+CAMPO_DIRECCION+" TEXT)";
}
