package programacion.proyecto.cristian.seller;

public class Utilidades {
    //TABLA CLIENTES ------------------------------------------------------------------------------------------------------------
    public static final String TABLA_CLIENTES = "clientes";

    //CAMPOS TABLA CLIENTES
    public static final String CAMPO_NOMBRE_NEGOCIO = "nombre_negocio";
    public static final String CAMPO_NOMBRE_CLIENTE = "nombre";
    public static final String CAMPO_APELLIDO = "apellido";
    public static final String CAMPO_CEDULA = "cedula";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CAMPO_DIRECCION = "direccion";

    //BORRA TABLA CLIENTES
    public static final String BORRAR_TABLA_CLIENTES = "DROP TABLE IF EXISTS "+ TABLA_CLIENTES;
    //------------------------------------------------------------------------------------------------------------------------------------

    //TABLA PEDIDOS --------------------------------------------------------------------------------------------------
    public static final String TABLA_PEDIDOS = "pedidos";

    //CAMPOS TABLA PEDIDOS
    public static final String CAMPO_TOTAL_PRODUCTOS = "productosPedidos";
    public static final String CAMPO_PRECIO_TOTAL = "total";

    //BORRA TABLA PEDIDOS
    public static final String BORRAR_TABLA_PEDIDOS = "DROP TABLE IF EXISTS "+ TABLA_PEDIDOS;
    //---------------------------------------------------------------------------------------------------------------

    //TABLA PRODUCTOS------------------------------------------------------------------------------------------------
    public static final String TABLA_PRODUCTOS = "productos";

    //CAMPOS TABLA PRODUCTOS
    public static final String CAMPO_NOMBRE_PRODUCTO = "nombre";
    public static final String CAMPO_DESCRIPCION = "descripcion";
    public static final String CAMPO_CANTIDAD_DISPONIBLE = "cantidad";
    public static final String CAMPO_PRECIO = "precio";
    public static final String CAMPO_RUTA_IMAGEN = "ruta_imagen";

    //BORRA TABLA PRODUCTOS
    public static final String BORRAR_TABLA_PRODUCTOS = "DROP TABLE IF EXISTS "+ TABLA_PRODUCTOS;
    //--------------------------------------------------------------------------------------------------------------

    //TABLA USUARIOS----------------------------------------------------------------------------------------------
    public static final String TABLA_USUARIOS = "usuarios";

    public static final String CAMPO_USUARIO = "usuario";
    public static final String CAMPO_CONTRASENA = "contrasena";

    public static final String BORRAR_TABLA_USUARIOS = "DROP TABLE IF EXISTS "+ TABLA_USUARIOS;
    //-------------------------------------------------------------------------------------------------------------

    public static final String CREAR_USUARIO = "INSERT INTO " + TABLA_USUARIOS + "('" + CAMPO_USUARIO +"','"+CAMPO_CONTRASENA +"') " +
            "VALUES('cristian2099', '12345')";

    public static final String CREAR_TABLA_CLIENTES = "CREATE TABLE " + TABLA_CLIENTES + "("+CAMPO_NOMBRE_NEGOCIO+" TEXT, "+CAMPO_NOMBRE_CLIENTE+" TEXT,"
            +CAMPO_APELLIDO+" TEXT, "+CAMPO_CEDULA+" PRIMARY KEY , "+CAMPO_TELEFONO+" TEXT, " +CAMPO_DIRECCION+" TEXT)";

    public static final String CREAR_TABLA_PEDIDOS = "CREATE TABLE " + TABLA_PEDIDOS + "("+CAMPO_NOMBRE_NEGOCIO+" TEXT, "+CAMPO_TOTAL_PRODUCTOS+" TEXT,"
            +CAMPO_PRECIO_TOTAL + " TEXT)";

    public static final String CREAR_TABLA_PRODUCTOS = "CREATE TABLE " + TABLA_PRODUCTOS + "("+CAMPO_NOMBRE_PRODUCTO+" TEXT, "+CAMPO_DESCRIPCION+" TEXT,"
            +CAMPO_CANTIDAD_DISPONIBLE+" TEXT," +CAMPO_PRECIO+" TEXT,"+CAMPO_RUTA_IMAGEN+" TEXT)";

    public static final String CREAR_TABLA_USUARIOS = "CREATE TABLE " + TABLA_USUARIOS + "("+CAMPO_USUARIO+" TEXT, "+CAMPO_CONTRASENA+" TEXT)";
}